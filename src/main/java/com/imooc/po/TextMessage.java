package com.imooc.po;


public class TextMessage extends BaseMessage{
	public String Content;
	//	图片链接（由系统生成）
	public String MediaId;
	//	图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	public String MsgId;
	//	消息id，64位整型
	
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	
}
