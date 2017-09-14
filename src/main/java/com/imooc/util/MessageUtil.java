package com.imooc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.imooc.po.Image;
import com.imooc.po.ImageMessage;
import com.imooc.po.Music;
import com.imooc.po.MusicMessage;
import com.imooc.po.News;
import com.imooc.po.NewsMessage;
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
	public static final String MESSAGE_NEWS = "news";
	public static final String MESSAGE_MUSIC = "music";
	public static final String MESSAGE_SCANCODE= "scancode_push";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";

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
	/**
	 * 图文消息转化为XML
	 * @param newsMessage
	 * @return
	 */
	public static String newsMessageToXml(NewsMessage newsMessage){
		XStream xstream = new XStream();
		xstream.alias("xml",newsMessage.getClass());
		xstream.alias("item",new News().getClass());
		return xstream.toXML(newsMessage);
	}
	
	/**
	 * 图片消息转为xml
	 * @param imageMessage
	 * @return
	 */
	public static String imageMessageToXml(ImageMessage imageMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}
	
	/**
	 * 音乐消息转为xml
	 * @param musicMessage
	 * @return
	 */
	public static String musicMessageToXml(MusicMessage musicMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}
	
	/**
	 * 图文消息的组装
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initNewsMessage(String toUserName,String fromUserName){
		String message = null;
		List<News> newsList = new ArrayList<News>();
		NewsMessage newsMessage = new NewsMessage();

		News news = new News();
		news.setTitle("文本介绍");
		news.setDescription("StartTest");
		news.setPicUrl("http://img.mukewang.com/user/545847e20001163c02200220-40-40.jpg");
		news.setUrl("https://www.hao123.com/");

		newsList.add(news);

		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MESSAGE_NEWS);
		newsMessage.setArticles(newsList);
		newsMessage.setArticleCount(newsList.size());
	
		message = newsMessageToXml(newsMessage);
		return message;
	}
	
	/**
	 * 组装图片消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initImageMessage(String toUserName,String fromUserName){
		String message = null;
		Image image = new Image();
		image.setMediaId("oRIwuudA9WvWa0XCMx8XCbbtyg13g7e5E6jQms8KwBvbzlvjTksLn-I6dYBWA7ZA");
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setFromUserName(toUserName);
		imageMessage.setToUserName(fromUserName);
		imageMessage.setMsgType(MESSAGE_IMAGE);
		imageMessage.setCreateTime(new Date().getTime());
		imageMessage.setImage(image);
		message = imageMessageToXml(imageMessage);
		return message;
	}
	
	/**
	 * 组装音乐消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initMusicMessage(String toUserName,String fromUserName){
		String message = null;
		Music music = new Music();
		music.setThumbMediaId("ODVUaSkWkb8W9xNPK04yVYZZS08dNN_ibjwtTDDGebaxJT9FKSBfhIZykWTLTIbi");
		music.setTitle("see you again");
		music.setDescription("速7片尾曲");
		music.setMusicUrl("http://4121b8c7.ngrok.io/ssm/See You Again.mp3");
		music.setHQMusicUrl("http://4121b8c7.ngrok.io/ssm/See You Again.mp3");
		
		MusicMessage musicMessage = new MusicMessage();
		musicMessage.setFromUserName(toUserName);
		musicMessage.setToUserName(fromUserName);
		musicMessage.setMsgType(MESSAGE_MUSIC);
		musicMessage.setCreateTime(new Date().getTime());
		musicMessage.setMusic(music);
		message = musicMessageToXml(musicMessage);
		return message;
	}
}
