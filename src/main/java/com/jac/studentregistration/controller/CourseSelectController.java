package com.jac.studentregistration.controller;

import com.jac.studentregistration.dto.CallBackResult;
import com.jac.studentregistration.dto.CourseSelectExecution;
import com.jac.studentregistration.dto.Exposer;
import com.jac.studentregistration.entity.CourseSelect;
import com.jac.studentregistration.enums.CourseSelectStateEnum;
import com.jac.studentregistration.exception.CourseSelectCloseException;
import com.jac.studentregistration.exception.RepeatSelectException;
import com.jac.studentregistration.service.impl.CourseSelectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by codingBoy on 16/11/28.
 */
@Component
@RequestMapping("/courseselect")//url:模块/资源/{}/细分
public class CourseSelectController
{
    @Autowired
    private CourseSelectServiceImpl courseSelectService;
    /**
     * 所有可选课程
     * @param
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CallBackResult<List<CourseSelect>> list(@RequestParam(required = false) String academyId )
    {
        //list.jsp+mode=ModelAndView
        //获取列表页

        CourseSelect courseSelect=new CourseSelect();
        courseSelect.setAcademyId(academyId);


        CallBackResult<CourseSelectExecution> result;

        try {
            List list=courseSelectService.findAll(courseSelect);
            return new CallBackResult<List<CourseSelect>>(true,list);
        }
        catch (Exception e)
        {
            return new CallBackResult(false,e.getMessage());
        }
    }

    /**
     * 展示详细信息
     * @param courseselectId
     * @param
     * @return
     */
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    @ResponseBody
    public CallBackResult<CourseSelect> detail(@RequestParam("courseselectId") String courseselectId)
    {
        CourseSelect courseSelect=courseSelectService.get(courseselectId);
        return new CallBackResult<CourseSelect>(true,courseSelect);
    }



    /**
     * ajax ,json暴露秒杀接口的方法
     * 进行时间判断 返回md5
     * 下次带md5进行选课提交
     * @param courseselectId
     * @return
     */
    @RequestMapping(value = "/exposer",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public CallBackResult<Exposer> exposer(@RequestParam("courseselectId") String courseselectId)
    {
        CallBackResult<Exposer> result;
        try{
//            Exposer exposer=courseSelectService.exportSeckillUrl(courseselectId);
//            result=new CallBackResult<Exposer>(true,exposer);
            result=new CallBackResult<Exposer>();
        }catch (Exception e)
        {
            e.printStackTrace();
            result=new CallBackResult<Exposer>(false,e.getMessage());
        }

        return result;
    }

    @RequestMapping(value = "/execution",
            method = RequestMethod.POST,
            produces = {"application/json ;charset=UTF-8"})
    @ResponseBody
    public CallBackResult<CourseSelectExecution> execute(@RequestParam("courseselectId") String courseselectId,
                                                         @RequestParam("md5") String md5,
                                                         @CookieValue(value = "userPhone",required = false) Long userPhone)
    {
        if (userPhone==null)
        {
            return new CallBackResult<CourseSelectExecution>(false,"未注册");
        }
        CallBackResult<CourseSelectExecution> result;

        try {
            CourseSelectExecution execution = courseSelectService.executeSeckill(courseselectId, userPhone, md5);
            return new CallBackResult<CourseSelectExecution>(true, execution);
        }catch (RepeatSelectException e1)
        {
            CourseSelectExecution execution=new CourseSelectExecution(courseselectId, CourseSelectStateEnum.REPEAT_KILL);
            return new CallBackResult<CourseSelectExecution>(true,execution);
        }catch (CourseSelectCloseException e2)
        {
            CourseSelectExecution execution=new CourseSelectExecution(courseselectId, CourseSelectStateEnum.END);
            return new CallBackResult<CourseSelectExecution>(true,execution);
        }
        catch (Exception e)
        {
            CourseSelectExecution execution=new CourseSelectExecution(courseselectId, CourseSelectStateEnum.INNER_ERROR);
            return new CallBackResult<CourseSelectExecution>(true,execution);
        }

    }

    //获取系统时间
    @RequestMapping(value = "/time/now",method = RequestMethod.GET)
    @ResponseBody
    public CallBackResult<Long> time()
    {
        Date now=new Date();
        return new CallBackResult<Long>(true,now.getTime());
    }
}























