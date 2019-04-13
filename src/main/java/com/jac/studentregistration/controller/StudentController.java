package com.jac.studentregistration.controller;

import com.jac.studentregistration.dto.CallBackResult;
import com.jac.studentregistration.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by codingBoy on 16/11/28.
 */
@Component
@RequestMapping("/student")//url:模块/资源/{}/细分
public class StudentController {


    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CallBackResult<ArrayList<Student>> list(
            @RequestParam(required = false) String academyId,
            @RequestParam(required = false) String sno,
            @RequestParam(required = false) String studentName,
            @RequestParam(required = false) String status

    ) {
        return new CallBackResult<ArrayList<Student>>(true, new ArrayList<Student>());
    }

    /**
     * @param studentId
     * @MethodName:get
     * @Description:根据studentId获取员工
     * @return: 返回员工信息, 以json格式
     */
    @ResponseBody
    @GetMapping(value = "/detail/{studentId}")
    public CallBackResult<Student> get(@PathVariable(value = "studentId", required = true) String studentId) {

        return new CallBackResult<Student>(true, new Student());
    }

    @ResponseBody
    @PostMapping
    public CallBackResult<Student> save(@RequestBody Student student) {

        return new CallBackResult<Student>(true, new Student());
    }

    /**
     * @param studentId URL占位符参数
     * @MethodName:delete
     * @Description:删除员工
     * @return: 返回员工列表, 以json格式 默认为逻辑删除--即修改flag标志
     */
    @ResponseBody
    @DeleteMapping(value = "/delete/{studentId}")
    public CallBackResult<Student> delete(@PathVariable(required = true) String studentId) {

        return new CallBackResult<Student>(true, new Student());
    }

    /**
     * @param student 用户修改后传回来的post
     * @MethodName:update
     * @Description:更新员工 更新时没有填的null jpa也会更新 所以要确定更改的字段 找到旧对对象再填充
     * @return: 返回成功信息, 以json格式
     */
    @ResponseBody
    @PutMapping(value = "/update")
    public CallBackResult<Student> update(@RequestBody Student student) {

        return new CallBackResult<Student>(true, new Student());
    }


}























