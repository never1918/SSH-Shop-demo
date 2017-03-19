package com.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jeff E-mail:Jeff@ProTest.com
 * @version 创建时间：2017年3月19日 下午10:35:36
 * 类说明
 * 拦截器
 */
public class HandlerInterceptor1 implements HandlerInterceptor{

	//进入Handler方法之前执行
	//用于身份认证、身份授权
	//比如身份验证，如果认证没通过，则不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//true放行
		//false拦截
		System.out.println("HandlerInterceptor1...preHandle");
		return true;
	}

	//进入Handler方法之后，返回modelAndView之前执行
	//存放公用的模型数据
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("HandlerInterceptor1...postHandle");
	}

	//执行Handler完成执行此方法
	//统一异常处理||统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
					throws Exception {

		System.out.println("HandlerInterceptor1...afterCompletion");
	}

}
