package com.chanlin.pet.test;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import com.chanlin.pet.model.User;
import com.chanlin.pet.service.UserServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class Test {
	private static final Logger logger = Logger.getLogger(Test.class);
	private UserServiceI userService;
	
		public UserServiceI getUserService() {
			return userService;
		}
	
		@Autowired
		public void setUserService(UserServiceI userService) {
			this.userService = userService;
		}
		
		@org.junit.Test
		public void test1() {
			User u = userService.login();
			logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
		}
}
