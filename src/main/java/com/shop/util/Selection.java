package com.shop.util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;


/**
 * �?个文档中选择的部�?
 * 说明�?
 * 作�?�：xudd
 * 创建时间�?2014-7-3 上午09:41:47
 * 修改时间�?2014-7-3 上午09:41:47
 */
public class Selection extends BaseWord{
	private ActiveXComponent wordApp;
	
	public Selection(Dispatch instance,ActiveXComponent wordApp) {
		super(instance);
		this.wordApp=wordApp;
	}

	/**
	 * 设置选择区的文字
	 * 
	 * 说明�?
	 * @param text
	 * @throws Exception
	 * 创建时间�?2014-7-3 上午09:41:47
	 */
	public void setText(String text) throws Exception{
		Dispatch.put(instance, "Text", text);
	}
	
	/**
	 * 用新文字替换旧文�?
	 * 
	 * 说明�?
	 * @param oldText
	 * @param newText
	 * @throws Exception
	 * 创建时间�?2014-7-3 上午09:41:47
	 */
	public void replace(String oldText,String newText) throws Exception{
		while (find(oldText)) {
			Dispatch.put(instance, "Text", newText);
			Dispatch.call(instance, "MoveRight");
		}
	}
	
	/**
	 * 查找字符�?
	 * 
	 * 说明�?
	 * @param toFindText
	 * @return
	 * 创建时间�?2014-7-3 上午09:41:47
	 */
	private boolean find(String toFindText) {
		if (toFindText == null || toFindText.equals(""))
			return false;
		
		// 从selection�?在位置开始查�?
		Dispatch find = wordApp.call(instance, "Find").toDispatch();
		// 设置要查找的内容
		Dispatch.put(find, "Text", toFindText);
		// 向前查找
		Dispatch.put(find, "Forward", "True");
		// 设置格式
		Dispatch.put(find, "Format", "True");
		// 大小写匹�?
		Dispatch.put(find, "MatchCase", "True");
		// 全字匹配
		Dispatch.put(find, "MatchWholeWord", "False");
		// 查找并�?�中
		return Dispatch.call(find, "Execute").getBoolean();
	}
	
	/**
	 * 插入图片
	 * 
	 * 说明�?
	 * @param imagePath
	 * 创建时间�?2014-7-3 上午09:41:47
	 */
	public void insertPicture(String imagePath){
		Dispatch.call(Dispatch.get(instance, "InLineShapes").toDispatch(),
				"AddPicture", imagePath);
	}
}