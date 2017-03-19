package com.shop.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shop.controller.validation.ValidGroup1;
import com.shop.exception.CustomException;
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

	//商品分类
	@ModelAttribute("itemtypes")
	public Map<String,String> getItemTypes(){

		Map<String,String> itemTypes = new HashMap<String,String>();
		itemTypes.put("101", "数码");
		itemTypes.put("102", "母婴");

		return itemTypes;
	}

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

		if(itemsCustom == null){
			throw new CustomException("修改的商品信息不存在");
		}

		model.addAttribute("items", itemsCustom);

		return "items/editItems";

	}	

	//商品信息修改提交
	//需要校验的pojo前边添加@Validated,BindingResult bindingRsult接受出错信息
	//@Validated和BindingResult对应出现。
	//@ModelAttribute可以指定pojo回显页面指定的key
	@RequestMapping("editItemsSubmit")
	public String editItemsSubmit(Model model,HttpServletRequest request,Integer id,@ModelAttribute("items") @Validated(value={ValidGroup1.class}) ItemsCustom itemsCustom,BindingResult bindingResult,MultipartFile items_pic)throws Exception{

		//获取错误信息
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors = bindingResult.getAllErrors();

			for(ObjectError objectError:allErrors){
				System.out.print(objectError.getDefaultMessage());
			}
			//传参
			model.addAttribute("allErrors", allErrors);
			//返回
			return "items/editItems";
		}

		//原始名称
		String originFileName = items_pic.getOriginalFilename();

		//上传图片
		if(items_pic!=null && originFileName!=null && originFileName.length()>0){

			//存储图片的物理路径
			String pic_path = "D:\\VC练习用文件夹\\temp\\";

			String newfilename = UUID.randomUUID() +originFileName.substring(originFileName.lastIndexOf("."));
			//新图片
			File newFile = new java.io.File(pic_path+newfilename);
			//将内存数据写入磁盘
			items_pic.transferTo(newFile);

			//将图片名称写入
			itemsCustom.setPic(newfilename);

		}

		itemsService.updateItems(id, itemsCustom);

		//使用Model也可以回显
		model.addAttribute("items", itemsCustom);

		//		return "redirect:queryItems.action";

		//		return "forward:queryItems.action";

		return "success";
	}

	//批量删除商品信息
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id)throws Exception{

		//调用service

		return "success";
	}

	//批量修改商品信息，将查询结果输出，并可以在页面编辑
	@RequestMapping("/editItemsQuery")
	public String editItemsQuery(Model model,ItemsQueryVo itemsQueryVo)throws Exception{

		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

		model.addAttribute("itemsList", itemsList);

		return "items/editItemsQuery";

	}	

	//批量修改商品提交
	//接受批量提交的商品信息，存储到List属性中。
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo)throws Exception{

		return "success";
	}
}
