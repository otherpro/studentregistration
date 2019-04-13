package com.jac.studentregistration.controller;

import com.jac.studentregistration.dto.CallBackResult;
import com.jac.studentregistration.entity.Course;
import com.jac.studentregistration.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by codingBoy on 16/11/28.
 */
@Component
@RequestMapping("/course")//url:模块/资源/{}/细分
public class CourseController {
@Autowired
    CourseServiceImpl courseService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CallBackResult<ArrayList<Course>> list(
            @RequestParam(required = false) String course

    ) {
        return new CallBackResult<ArrayList<Course>>(true, new ArrayList<Course>());
    }

    /**
     * @param courseId
     * @MethodName:get
     * @Description:根据studentId获取员工
     * @return: 返回员工信息, 以json格式
     */
    @ResponseBody
    @GetMapping(value = "/detail")
    public CallBackResult<Course> get(@RequestParam(value = "courseId", required = true) String courseId) {

        return new CallBackResult<Course>(true, courseService.get(courseId));
    }

    @ResponseBody
    @PostMapping
    public CallBackResult<Course> save(@RequestBody Course course) {

        return new CallBackResult<Course>(true, new Course());
    }

    /**
     * @param courseId URL占位符参数
     * @MethodName:delete
     * @Description:删除员工
     * @return: 返回员工列表, 以json格式 默认为逻辑删除--即修改flag标志
     */
    @ResponseBody
    @DeleteMapping(value = "/delete/{courseId}")
    public CallBackResult<Course> delete(@PathVariable(required = true) String courseId) {

        return new CallBackResult<Course>(true, new Course());
    }

    /**
     * @param course 用户修改后传回来的post
     * @MethodName:update
     * @Description:更新员工 更新时没有填的null jpa也会更新 所以要确定更改的字段 找到旧对对象再填充
     * @return: 返回成功信息, 以json格式
     */
    @ResponseBody
    @PutMapping(value = "/update")
    public CallBackResult<Course> update(@RequestBody Course course) {

        return new CallBackResult<Course>(true, new Course());
    }


}























