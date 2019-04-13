package com.jac.studentregistration.controller;

import com.jac.studentregistration.dto.CallBackResult;
import com.jac.studentregistration.entity.Academy;
import com.jac.studentregistration.service.impl.AcademyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by codingBoy on 16/11/28.
 */
@Component
@RequestMapping("/academy")//url:模块/资源/{}/细分
public class AcademyController {
    @Autowired
    private AcademyServiceImpl academyService;


    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CallBackResult<List<Academy>> list(
            @RequestParam(required = false) String academy

    ) {
        return new CallBackResult<List<Academy>>(true, academyService.listAll());
    }

    /**
     * @param academyId
     * @MethodName:get
     * @Description:根据studentId获取员工
     * @return: 返回员工信息, 以json格式
     */
    @ResponseBody
    @GetMapping(value = "/detail/{academyId}")
    public CallBackResult<Academy> get(@PathVariable(value = "academyId", required = true) String academyId) {

        return new CallBackResult<Academy>(true, new Academy());
    }

    @ResponseBody
    @PostMapping
    public CallBackResult<Academy> save(@RequestBody Academy academy) {

        return new CallBackResult<Academy>(true, new Academy());
    }

    /**
     * @param academyId URL占位符参数
     * @MethodName:delete
     * @Description:删除员工
     * @return: 返回员工列表, 以json格式 默认为逻辑删除--即修改flag标志
     */
    @ResponseBody
    @DeleteMapping(value = "/delete/{academyId}")
    public CallBackResult<Academy> delete(@PathVariable(required = true) String academyId) {

        return new CallBackResult<Academy>(true, new Academy());
    }

    /**
     * @param academy 用户修改后传回来的post
     * @MethodName:update
     * @Description:更新员工 更新时没有填的null jpa也会更新 所以要确定更改的字段 找到旧对对象再填充
     * @return: 返回成功信息, 以json格式
     */
    @ResponseBody
    @PutMapping(value = "/update")
    public CallBackResult<Academy> update(@RequestBody Academy academy) {

        return new CallBackResult<Academy>(true, new Academy());
    }


}























