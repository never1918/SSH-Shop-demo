package com.shop.exception;
/**
 * @author Jeff E-mail:Jeff@ProTest.com
 * @version 创建时间：2017年3月19日 下午4:47:22
 * 类说明
 * 系统自定义异常类
 */
public class CustomException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -179089718199141668L;
	//异常信息
	public String message;
	
	public CustomException(String message){
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
