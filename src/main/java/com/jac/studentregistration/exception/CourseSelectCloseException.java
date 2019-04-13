package com.jac.studentregistration.exception;

/**
 * 秒杀关闭异常，当秒杀结束时用户还要进行秒杀就会出现这个异常
 * Created by codingBoy on 16/11/27.
 */
public class CourseSelectCloseException extends CourseSelectException{
    public CourseSelectCloseException(String message) {
        super(message);
    }

    public CourseSelectCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
