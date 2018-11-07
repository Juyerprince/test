package com.iotek.controller;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.entity.User;
import com.iotek.service.UserService;
import com.iotek.utils.ImageCodeUtil;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/init.do")
	public String init() {
		return "login";
	}

	@RequestMapping("/initRegist.do")
	public String initRegist() {
		return "regist";
	}

	@RequestMapping("/login.do")
	public String login(String userName, String pwd, String userCode, Model model, HttpSession session) {
		User user = userService.queryUserByName2Pwd(userName, pwd);
		if (user == null) {
			model.addAttribute("mesg", "用户名或密码错误");
			return "login";
		}
		String code = (String) session.getAttribute("code");
		System.out.println(code);
		if (userCode == null || userCode == "" || !code.equals(userCode)) {
			model.addAttribute("mesg", "验证码错误");
			return "login";
		}
		System.out.println(userCode);
		session.setAttribute("user", user);
		return "main";
	}

	@RequestMapping("/regist.do")
	public String regist(String userName, String pwd, Model model) {
		if (userService.regist(userName, pwd)) {
			model.addAttribute("mesg", "注册成功");
			return "login";
		}
		model.addAttribute("mesg", "注册失败");
		return "regist";
	}

	@RequestMapping("/imageCode.do")
	public void imageCode(HttpServletResponse response, HttpServletRequest request, HttpSession session) {
		// 通知浏览器不要缓存
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "-1");
		ImageCodeUtil util = ImageCodeUtil.Instance();
		// 将验证码输入到session中，用来验证
		String code = util.getString();
		session.setAttribute("code", code);
		// 输出打web页面
		try {
			ImageIO.write(util.getImage(), "jpg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
