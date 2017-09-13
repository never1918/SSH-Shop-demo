package com.imooc.po;

public class BaseMessage {
	public String ToUserName;
	//	开发者微信号
	public String FromUserName;
	//	发送方帐号（一个OpenID）
	public Long CreateTime;
	//	消息创建时间 （整型）
	public String MsgType;
	//	image
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public Long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
}
