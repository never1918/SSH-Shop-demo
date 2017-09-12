package com.imooc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.imooc.po.TextMessage;
import com.thoughtworks.xstream.XStream;

public class MessageUtil {
	
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSRCIBE = "subsrcibe";
	public static final String MESSAGE_UNSUBSRCIBE = "unsubsrcibe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	/**
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String,String> xmlToMap(HttpServletRequest request)throws IOException,DocumentException{
		Map<String,String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		
		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins);
		
		Element root = doc.getRootElement();
		
		List<Element> list = root.elements();
		
		for(Element e :list){
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}
	/**
	 * 将文本对象转化为xml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml",textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	public static String initText(String toUserName,String fromUserName,String content){
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent("您发送的信息是："+content);
		return textMessageToXml(text);
	}
	
	/**
	 * 主菜单
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎您的关注，请按菜单提示进行操作：\n\n");
		sb.append("1、功能测试点一");
		sb.append("2、功能测试点二");
		sb.append("回复？调出此菜单");
		return sb.toString();
	}
	
	public static String firstText(){
		StringBuffer sb = new StringBuffer();
		sb.append("( ′◔ ‸◔`)为什么会进来这里");
		return sb.toString();
	}
	
	public static String secondText(){
		StringBuffer sb = new StringBuffer();
		sb.append("肯定是按了什么奇怪的按钮");
		return sb.toString();
	}
}
