package com.imooc.test;

import com.imooc.po.AccessToken;
import com.imooc.util.WeixinUtil;

public class WeixinTest {
	public static void main(String[] args) {
		AccessToken token = WeixinUtil.getAccessToken();
		System.out.println("票据"+token.getAccess_token());
		System.out.println("时间"+token.getExpires_in());
	}
}
