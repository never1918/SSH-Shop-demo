package com.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jeff E-mail:Jeff@ProTest.com
 * @version 创建时间：2017年3月19日 下午11:18:23
 * 类说明
 */
@Controller
public class LoginController {

	//登录
	@RequestMapping("/login")
	public String login(HttpSession session,String username,String password)throws Exception{
		
		session.setAttribute("username", username);
		
		return "redirect:/items/queryItems.action";
	}
	//退出
	@RequestMapping("/logout")
	public String logout(HttpSession session)throws Exception{
		
		session.invalidate();
		
		return "redirect:/items/queryItems.action";
	}
	
	
	
}
