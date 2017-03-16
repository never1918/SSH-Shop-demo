package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.model.ItemsCustom;
import com.shop.model.ItemsQueryVo;
import com.shop.service.ItemsService;

/**
 * @author Jeff E-mail:Jeff@ProTest.com
 * @version 创建时间：2017年3月15日 下午10:50:48
 * 类说明
 */

@Controller
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	//商品查询列表
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,Integer id,ItemsQueryVo itemsQueryVo)throws Exception{

		//调用service查询数据库
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("itemsList",itemsList);

		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}

	//商品信息修改页面显示
	@RequestMapping("/editItems")
	public String editItems(Model model,@RequestParam(value="id") Integer items_id)throws Exception{

		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);

		model.addAttribute("itemsCustom", itemsCustom);

		return "items/editItems";

	}	

	//商品信息修改提交
	@RequestMapping("editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request,Integer id,ItemsCustom itemsCustom)throws Exception{

		itemsService.updateItems(id, itemsCustom);
		
		return "redirect:queryItems.action";

//		return "forward:queryItems.action";

//		return "success";
	}

}
