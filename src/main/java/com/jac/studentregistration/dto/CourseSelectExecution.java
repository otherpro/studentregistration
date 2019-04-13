package com.jac.studentregistration.dto;

import com.jac.studentregistration.entity.CourseSelect;
import com.jac.studentregistration.enums.CourseSelectStateEnum;


/**
 * 封装执行秒杀后的结果:是否秒杀成功
 * Created by codingBoy on 16/11/27.
 */
public class CourseSelectExecution {

    private String courseSelectId;

    //秒杀执行结果的状态
    private int state;

    //状态的明文标识
    private String stateInfo;

    //当秒杀成功时，需要传递秒杀成功的对象回去
    private CourseSelect courseSelect;

    //秒杀成功返回所有信息
    public CourseSelectExecution(String courseSelectId, CourseSelectStateEnum statEnum, CourseSelect courseSelect) {
        this.courseSelectId = courseSelectId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getInfo();
        this.courseSelect = courseSelect;
    }

    //秒杀失败
    public CourseSelectExecution(String courseSelectId, CourseSelectStateEnum statEnum) {
        this.courseSelectId = courseSelectId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getInfo();
    }

}
