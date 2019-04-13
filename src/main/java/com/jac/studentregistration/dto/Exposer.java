package com.jac.studentregistration.dto;

import lombok.Data;

/**
 * Created by codingBoy on 16/11/27.
 * 暴露秒杀地址(接口)DTO
 */
@Data
public class Exposer {

    //是否开启秒杀
    private boolean exposed;

    //加密措施
    private String md5;

    private String courseSelectId;

    //系统当前时间(毫秒)
    private long now;

    //秒杀的开启时间
    private long start;

    //秒杀的结束时间
    private long end;
    public Exposer(boolean exposed, String md5, String courseSelectId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.courseSelectId = courseSelectId;
    }

    public Exposer(boolean exposed, String courseSelectId,long now, long start, long end) {
        this.exposed = exposed;
        this.courseSelectId=courseSelectId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, String courseSelectId) {
        this.exposed = exposed;
        this.courseSelectId = courseSelectId;
    }

}
