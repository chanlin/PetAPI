package com.chanlin.pet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.chanlin.pet.common.Result;
import com.chanlin.pet.common.Status;
import com.chanlin.pet.common.StatusInfoException;
import com.chanlin.pet.model.User;
import com.chanlin.pet.service.UserServiceI;
import com.sun.org.glassfish.external.statistics.Stats;

@Controller
@RequestMapping("/userController")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	private UserServiceI userService;
	private static Result result = new Result();

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	/**
	 * 
	 * @Title: getVCode @Description: TODO 获取验证码接口 @param mobile
	 * 接收短信的手机号 @return void @throws
	 */
	@RequestMapping("/getVCode")
	public void getVCode(HttpServletRequest req) {
		String mobile = req.getParameter("mobile");
		if (mobile != null) {
			// 产生验证码

			// 调用短信认证接口

			// 验证码放入到session中
		} else {
			logger.warn("获取验证码接口中的mobile为空！");
		}

	}

	/**
	 * 
	 * @Title: login @Description: 登录接口 @param @param id @param @param
	 * name @param @return 设定文件 @return User 使用Spring内置的支持 返回
	 * 对象，内置转成json @throws
	 */
	@RequestMapping("/login")
	@ResponseBody
	public User login(@RequestParam(value = "id") Integer id, @RequestParam(value = "name") String name) {
		System.out.print("id=" + id + ",name=" + name);
		User user = userService.login();

		return user;
	}

	/**
	 * @throws StatusInfoException
	 * 
	 * @Title: register @Description: TODO @param req @param rep @return void 直接
	 * PrintWriter输出json @throws
	 */
	@RequestMapping("/register")
	public void register(HttpServletRequest req, HttpServletResponse rep) throws IOException {
		/*
		 * @param mobile
		 * 
		 * @param vkey
		 * 
		 * @param password （明文，服务端加密）
		 */
		String mobile = req.getParameter("mobile");
		String vkey = req.getParameter("vkey");
		String password = req.getParameter("password");
		// session中获取到vkey 做比较
		if ("123456".equals(vkey)) {
			User user = new User();
			user.setuPhone(mobile);
			user.setuPassword(password);
			int cont = userService.addUser(user);
			if (cont > 0) {
				result.setStatus(Status.SUCCESS_STATUS);
				result.setInfo(Status.SUCCESS_INFO);
				result.setData("注册成功！");
			} else {
				result.setStatus(Status.ERROR_STATUS);
				result.setInfo(Status.ERROR_INFO);
				result.setData("注册失败！");
			}
		} else {
			result.setStatus(Status.ERROR_STATUS);
			result.setInfo(Status.ERROR_INFO);
			result.setData("验证码错误！");
		}
		String ret = JSON.toJSONString(result);
		PrintWriter writer = rep.getWriter();
		writer.println(ret);
		writer.flush();
		writer.close();
	}

	/**
	 * 
	 * @Title: forgetPw @Description: TODO 找回密码：重置密码 @param mobile 手机号 @param
	 * password 新密码 @param vkey 验证短信验证码时返回的票据 @return Result @throws
	 */
	@RequestMapping("forgetPw")
	@ResponseBody
	private Result forgetPw(HttpServletRequest req) {
		String mobile = req.getParameter("mobile");
		String password = req.getParameter("password");
		String vKey = req.getParameter("vkey");

		int count = userService.updatePwd(mobile, password);
		if (count > 0) {
			result.setStatus(Status.SUCCESS_STATUS);
			result.setInfo(Status.SUCCESS_INFO);
			result.setData("密码修改成功！");
		}
		{
			result.setStatus(Status.ERROR_STATUS);
			result.setInfo(Status.ERROR_INFO);
			result.setData("修改错误！");
		}
		return null;

	}

}
