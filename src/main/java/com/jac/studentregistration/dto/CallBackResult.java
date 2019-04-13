package com.jac.studentregistration.dto;

import lombok.Data;

/**
 * Created by codingBoy on 16/11/28.
 */
//将所有的ajax请求返回类型，全部封装成json数据
@Data
public class CallBackResult<T> {

    //请求是否成功
    private boolean success;
    private T data;
    private String error;
    private int errno;

    public CallBackResult() {
    }

    public CallBackResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public CallBackResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public CallBackResult(boolean success, T data, String error, int errno) {
        this.success = success;
        this.data = data;
        this.error = error;
        this.errno = errno;
    }
}
