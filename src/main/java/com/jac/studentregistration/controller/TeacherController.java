package com.jac.studentregistration.controller;

import com.jac.studentregistration.dto.CallBackResult;
import com.jac.studentregistration.entity.Teacher;
import com.jac.studentregistration.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by codingBoy on 16/11/28.
 */
@Component
@RequestMapping("/teacher")//url:模块/资源/{}/细分
public class TeacherController {
@Autowired
    TeacherServiceImpl teacherService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CallBackResult<ArrayList<Teacher>> list(
            @RequestParam(required = false) String academyId,
            @RequestParam(required = false) String tno,
            @RequestParam(required = false) String teacherName,
            @RequestParam(required = false) String status
    ) {
        return new CallBackResult<ArrayList<Teacher>>(true, new ArrayList<Teacher>());
    }

    /**
     * @param teacherId
     * @MethodName:get
     * @Description:根据studentId获取员工
     * @return: 返回员工信息, 以json格式
     */
    @ResponseBody
    @GetMapping(value = "/detail")
    public CallBackResult<Teacher> get(@RequestParam(value = "teacherId", required = true) String teacherId) {

        return new CallBackResult<Teacher>(true, teacherService.get(teacherId));
    }

    @ResponseBody
    @PostMapping
    public CallBackResult<Teacher> save(@RequestBody Teacher teacher) {

        return new CallBackResult<Teacher>(true, new Teacher());
    }

    /**
     * @param teacherId URL占位符参数
     * @MethodName:delete
     * @Description:删除员工
     * @return: 返回员工列表, 以json格式 默认为逻辑删除--即修改flag标志
     */
    @ResponseBody
    @DeleteMapping(value = "/delete/{teacherId}")
    public CallBackResult<Teacher> delete(@PathVariable(required = true) String teacherId) {

        return new CallBackResult<Teacher>(true, new Teacher());
    }

    /**
     * @param teacher 用户修改后传回来的post
     * @MethodName:update
     * @Description:更新员工 更新时没有填的null jpa也会更新 所以要确定更改的字段 找到旧对对象再填充
     * @return: 返回成功信息, 以json格式
     */
    @ResponseBody
    @PutMapping
    public CallBackResult<Teacher> update(@RequestBody Teacher teacher) {

        return new CallBackResult<Teacher>(true, new Teacher());
    }


}























