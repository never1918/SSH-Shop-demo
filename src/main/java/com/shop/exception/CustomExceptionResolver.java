package com.shop.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jeff E-mail:Jeff@ProTest.com
 * @version 创建时间：2017年3月19日 下午4:50:43
 * 类说明
 * 全局异常处理
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{

	/*
	 * 
	 * 
	 */

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response,Object handler,Exception ex){
		//		String message = null;
		//		if(ex instanceof CustomException){
		//			message = ((CustomException)ex).getMessage(); 
		//		}else{
		//			message="未知错误";
		//		}

		CustomException customException = null;
		if(ex instanceof CustomException){
			customException = (CustomException)ex;
		}else{
			customException = new CustomException("未知错误");
		}
		
		//错误信息
		String message = customException.getMessage();
		
		ModelAndView modelAndView = new ModelAndView();
		
		//讲错误信息传到页面
		modelAndView.addObject("message", message);
		//指向错误页面
		modelAndView.setViewName("error");
		
		return modelAndView;
	}
}
