package com.jac.studentregistration.utils;

import org.springframework.util.DigestUtils;

/**
 * @author Jac
 * @date 2019-03-30 22:48
 */
public class EnDecryptUtil {

    //加入一个混淆字符串(秒杀接口)的salt，为了我避免用户猜出我们的md5值，值任意给，越复杂越好
    private final static String salt = "shsdssljdd'l.";

    public static  String getMD5(String seckillId) {
        String base = seckillId + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
