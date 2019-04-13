package com.jac.studentregistration.controller;

import com.jac.studentregistration.dto.CallBackResult;
import com.jac.studentregistration.entity.Course;
import com.jac.studentregistration.entity.StudentCourse;
import com.jac.studentregistration.service.impl.StudentCourseServiceImpl;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codingBoy on 16/11/28.
 */
@Component
@RequestMapping("/studentCourse")//url:模块/资源/{}/细分
public class StudentCourseController {
    @Autowired
    StudentCourseServiceImpl studentCourseService;

    /**
     * 返回学生选课 当前学期 学生学期选择 获取所有之后再筛选第几学期的
     *
     * @param studentId
     * @param courseId
     * @param grade
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CallBackResult<List<Course>> list(
            @RequestParam(required = false) String studentId,
            @RequestParam(required = false) String courseId,
            @RequestParam(required = false) String grade
    ) {
        studentId="1";
        List<Course> list;
        if (StringUtil.isNullOrEmpty(grade)) {
            list=studentCourseService.listByStuIdAndSortByLesson(studentId);
        } else {
            list= studentCourseService.listByStuIdAndGrade(studentId, grade);
        }

        return new CallBackResult<List<Course>>(true, list);
    }


    @ResponseBody
    @GetMapping(value = "/detail/{studentCourseId}")
    public CallBackResult<StudentCourse> get(@PathVariable(value = "studentCourseId", required = true) String studentCourseId) {

        return new CallBackResult<StudentCourse>(true, new StudentCourse());
    }

    @ResponseBody
    @PostMapping
    public CallBackResult<StudentCourse> save(@RequestBody StudentCourse studentCourse) {

        return new CallBackResult<StudentCourse>(true, new StudentCourse());
    }

    /**
     * @param studentCourseId URL占位符参数
     * @MethodName:delete
     * @Description:物理删除--退课
     * @return:
     */
    @ResponseBody
    @DeleteMapping(value = "/delete/{studentCourseId}/{courseId}")
    public CallBackResult<StudentCourse> delete(@PathVariable(required = true) String studentCourseId,
                                                @PathVariable(required = true) String courseId) {

        return new CallBackResult<StudentCourse>(true, new StudentCourse());
    }

    /**
     * @param studentCourse 用户修改后传回来的post
     * @MethodName:update
     * @Description:更新员工 更新时没有填的null jpa也会更新 所以要确定更改的字段 找到旧对对象再填充
     * @return: 返回成功信息, 以json格式
     */
    @ResponseBody
    @PutMapping(value = "/update")
    public CallBackResult<StudentCourse> update(@RequestBody StudentCourse studentCourse) {

        return new CallBackResult<StudentCourse>(true, new StudentCourse());
    }


}























