package com.jac.studentregistration.enums;

/**
 * Created by codingBoy on 16/11/28.
 */
public enum CourseSelectStateEnum {

    SUCCESS(1,"选课成功"),
    END(0,"选课结束"),
    REPEAT_KILL(-1,"重复选课"),
    INNER_ERROR(-2,"系统异常"),
    DATE_REWRITE(-3,"数据篡改");

    private int state;
    private String info;

    CourseSelectStateEnum(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }


    public String getInfo() {
        return info;
    }


    public static CourseSelectStateEnum stateOf(int index)
    {
        for (CourseSelectStateEnum state : values())
        {
            if (state.getState()==index)
            {
                return state;
            }
        }
        return null;
    }
}
