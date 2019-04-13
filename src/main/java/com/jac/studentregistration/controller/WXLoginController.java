package com.jac.studentregistration.controller;


import com.jac.studentregistration.common.HttpClientUtil;
import com.jac.studentregistration.common.IMoocJSONResult;
import com.jac.studentregistration.common.JsonUtils;
import com.jac.studentregistration.common.RedisOperator;
import com.jac.studentregistration.dto.WXSessionModel;
import com.jac.studentregistration.entity.Academy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WXLoginController {
	
	@Autowired
	private RedisOperator redis;
	

	@PostMapping("/wxLogin")
	public IMoocJSONResult wxLogin(String code) {
		
		System.out.println("wxlogin - code: " + code);
		
//		https://api.weixin.qq.com/sns/jscode2session?
//				appid=APPID&
//				secret=SECRET&
//				js_code=JSCODE&
//				grant_type=authorization_code
		
		String url = "https://api.weixin.qq.com/sns/jscode2session";
		Map<String, String> param = new HashMap<>();
		param.put("appid", "wx7e7f2a58addbea7a");
		param.put("secret", "c95037670f957e8da2c1531db92880b4");
		param.put("js_code", code);
		param.put("grant_type", "authorization_code");
		
		String wxResult = HttpClientUtil.doGet(url, param);
		System.out.println(wxResult);
		
		WXSessionModel model = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);
		
		// 存入session到redis
		redis.set("user-redis-session:" + model.getOpenid(), 
							model.getSession_key(), 
							1000 * 60 * 30);
		Academy aca=new Academy();
		aca.setAcademyId("testwx");
		aca.setClassName("tstwxname");
		aca.setAcademyName("testwxacademyname");
		return IMoocJSONResult.ok(aca);
	}
	
}
