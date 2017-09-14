package com.imooc.test;

import net.sf.json.JSONObject;

import com.imooc.po.AccessToken;
import com.imooc.util.WeixinUtil;

public class WeixinTest {
	public static void main(String[] args) {
		try{
			AccessToken token = WeixinUtil.getAccessToken();
			System.out.println("票据"+token.getAccess_token());
			System.out.println("时间"+token.getExpires_in());
			//			String path = "C:/Users/Administrator/Desktop/1.png";
			//			String mediaId = WeixinUtil.upload(path, token.getAccess_token(), "thumb");
			//			System.out.println(mediaId);
			String menu = JSONObject.fromObject(WeixinUtil.initMenu()).toString();
			int result = WeixinUtil.createMenu(token.getAccess_token(), menu);
			if (result==0){
				System.out.print("successfully create menu");
			}else{
				System.out.print("error create:error msg:"+result);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
