package com.jac.studentregistration.exception;

/**
 * 秒杀相关的所有业务异常
 * Created by codingBoy on 16/11/27.
 */
public class CourseSelectException extends RuntimeException {
    public CourseSelectException(String message) {
        super(message);
    }

    public CourseSelectException(String message, Throwable cause) {
        super(message, cause);
    }
}
