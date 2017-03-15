package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.model.ItemsCustom;
import com.shop.service.ItemsService;

/**
 * @author Jeff E-mail:Jeff@ProTest.com
 * @version 创建时间：2017年3月15日 下午10:50:48
 * 类说明
 */

@Controller
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	//商品查询列表
	@RequestMapping("/queryItems")
	public ModelAndView queryItems()throws Exception{

		//调用service查询数据库
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("itemsList",itemsList);

		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}
}
