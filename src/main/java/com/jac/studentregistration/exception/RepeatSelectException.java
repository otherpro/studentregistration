package com.jac.studentregistration.exception;

/**
 * 重复秒杀异常，是一个运行期异常，不需要我们手动try catch
 * Mysql只支持运行期异常的回滚操作
 * Created by codingBoy on 16/11/27.
 */
public class RepeatSelectException extends CourseSelectException {

    public RepeatSelectException(String message) {
        super(message);
    }

    public RepeatSelectException(String message, Throwable cause) {
        super(message, cause);
    }
}
