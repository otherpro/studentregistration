package com.jac.studentregistration.service.impl;

import com.jac.studentregistration.dao.CourseDao;
import com.jac.studentregistration.dao.CourseSelectDao;
import com.jac.studentregistration.dto.CourseSelectExecution;
import com.jac.studentregistration.dto.Exposer;
import com.jac.studentregistration.entity.CourseSelect;
import com.jac.studentregistration.utils.EnDecryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Jac
 * @date 2019-03-27 22:15
 */
@Service
public class CourseSelectServiceImpl {
    @Autowired
    private CourseSelectDao courseSelectDao;
    @Autowired
    private CourseDao courseDao;

    /**
     * 获取根据id获取单个对象
     * 使用redis缓存
     *
     * @param courseSelectId
     * @return
     */
    public CourseSelect getById(String courseSelectId) {
//        return redisDao.getOrPutSeckill(seckillId, id -> courseSelectDao.getOne(id));\
        return courseSelectDao.getOne(courseSelectId);
    }

    /**
     * 再次从系统获取对象时间 防止前台篡改
     *
     * @param courseSelectId
     * @return
     */
    public Exposer exportCourseSelectUrl(String courseSelectId) {

        CourseSelect courseSelect = get(courseSelectId);

        //若是秒杀未开启
        Date startTime = courseSelect.getStartTime();
        Date endTime = courseSelect.getEndTime();
        //系统当前时间
        Date nowTime = new Date();
        if (startTime.getTime() > nowTime.getTime() || endTime.getTime() < nowTime.getTime()) {
            return new Exposer(false, courseSelectId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }

        //秒杀开启，返回秒杀商品的id、用给接口加密的md5
        String md5 = EnDecryptUtil.getMD5(courseSelectId);
        return new Exposer(true, md5, courseSelectId);
    }

    public CourseSelectExecution executeSeckill(String courseselectId, Long userPhone, String md5) {
        return null;
    }



    public CourseSelect add(CourseSelect courseSelect) {
        return courseSelectDao.save(courseSelect);
    }


    public List<CourseSelect> saveBatch(List<CourseSelect> courseSelectList) {
        return courseSelectDao.saveAll(courseSelectList);
    }

    /**
     * 设定所有课程开始结束选课时间
     * @param startTime
     * @param endTime
     */
    public void setTime(Date startTime, Date endTime) {

    }

    public void delete(String id) {
        courseSelectDao.deleteById(id);
    }

    public CourseSelect get(String id) {
        return courseSelectDao.getOne(id);
    }

    /**
     * 获取所有学院信息 列表 之后进行二项选择专业班级
     *
     * @return
     */
    public List<CourseSelect> listAll() {
        return courseSelectDao.findAll();
    }

    public List<CourseSelect> findAll(CourseSelect courseSelect) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("courseName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("academyId", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("teacherId", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("grade", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("courseSelectId");//忽略字段，即不管password是什么值都不加入查询条件

        Example<CourseSelect> example = Example.of(courseSelect, matcher);
        return courseSelectDao.findAll(example);
    }

    public Page<CourseSelect> findAll(CourseSelect courseSelect, Pageable pageable) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("courseName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("academyId", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("teacherId", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("grade", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("courseSelectId");//忽略字段，即不管password是什么值都不加入查询条件

        Example<CourseSelect> example = Example.of(courseSelect, matcher);
        return courseSelectDao.findAll(example, pageable);
    }


}
