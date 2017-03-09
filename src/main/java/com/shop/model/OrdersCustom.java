package com.shop.model;
/**
 * @author Jeff E-mail:Jeff@ProTest.com
 * @version 创建时间：2017年3月9日 下午9:57:03
 * 类说明
 */
//通过此类映射订单和用户查询的结果，让此类继承包括字段较多的Pojo类
public class OrdersCustom extends Orders{
	
	//添加用户属性
	/*cnt_user.username
	 *cnt_user.sex
	 *cnt_user.address
	 */
	
	private String username;
	private String sex;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
