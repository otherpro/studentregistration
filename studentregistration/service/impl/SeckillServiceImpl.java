package com.jac.studentregistration.service.impl;


import com.jac.studentregistration.dao.StudentCourseDao;
import com.jac.studentregistration.dao.SuccessKilledDao;
import com.jac.studentregistration.dao.cache.RedisDao;
import com.jac.studentregistration.dto.Exposer;
import com.jac.studentregistration.dto.studentCourseExecution;
import com.jac.studentregistration.entity.studentCourse;
import com.jac.studentregistration.entity.SuccessKilled;
import com.jac.studentregistration.enums.studentCourseStatEnum;
import com.jac.studentregistration.exception.RepeatKillException;
import com.jac.studentregistration.exception.studentCourseCloseException;
import com.jac.studentregistration.exception.studentCourseException;
import com.jac.studentregistration.service.studentCourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by codingBoy on 16/11/28.
 */
//@Component @Service @Dao @Controller
@Service
public class studentCourseServiceImpl implements studentCourseService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //加入一个混淆字符串(秒杀接口)的salt，为了我避免用户猜出我们的md5值，值任意给，越复杂越好
    private final String salt = "shsdssljdd'l.";

    //注入Service依赖
    @Autowired //@Resource
    private StudentCourseDao studentCourseDao;

    @Autowired //@Resource
    private SuccessKilledDao successKilledDao;

    @Autowired
    private RedisDao redisDao;

    @Override
    public List<studentCourse> getstudentCourseList() {
        return studentCourseDao.queryAll(0, 4);
    }

    @Override
    public studentCourse getById(long studentCourseId) {
        return redisDao.getOrPutstudentCourse(studentCourseId, id -> studentCourseDao.queryById(id));
    }
    @Override
    public Exposer exportstudentCourseUrl(long studentCourseId) {

        studentCourse studentCourse = getById(studentCourseId);

        //若是秒杀未开启
        Date startTime = studentCourse.getStartTime();
        Date endTime = studentCourse.getEndTime();
        //系统当前时间
        Date nowTime = new Date();
        if (startTime.getTime() > nowTime.getTime() || endTime.getTime() < nowTime.getTime()) {
            return new Exposer(false, studentCourseId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }

        //秒杀开启，返回秒杀商品的id、用给接口加密的md5
        String md5 = getMD5(studentCourseId);
        return new Exposer(true, md5, studentCourseId);
    }

    private String getMD5(long studentCourseId) {
        String base = studentCourseId + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    public studentCourseExecution executestudentCourse(long studentCourseId, long userPhone, String md5)
            throws studentCourseException, RepeatKillException, studentCourseCloseException {

        if (md5 == null || !md5.equals(getMD5(studentCourseId))) {
            //秒杀数据被重写了
            throw new studentCourseException("studentCourse data rewrite");
        }
        //执行秒杀逻辑:减库存+增加购买明细
        Date nowTime = new Date();

        try {

            int insertCount = successKilledDao.insertSuccessKilled(studentCourseId, userPhone);
            if (insertCount <= 0) {
                throw new RepeatKillException("studentCourse repeated");
            } else {

                //减库存,热点商品竞争
                int updateCount = studentCourseDao.reduceNumber(studentCourseId, nowTime);
                if (updateCount <= 0) {
                    throw new studentCourseCloseException("studentCourse is closed");
                } else {
                    SuccessKilled successKilled = successKilledDao.queryByIdWithstudentCourse(studentCourseId, userPhone);
                    return new studentCourseExecution(studentCourseId, studentCourseStatEnum.SUCCESS, successKilled);
                }

            }


        } catch (studentCourseCloseException e1) {
            throw e1;
        } catch (RepeatKillException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所以编译期异常转化为运行期异常
            throw new studentCourseException("studentCourse inner error :" + e.getMessage());
        }

    }
}







