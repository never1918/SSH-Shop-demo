package com.shop.service;

import java.util.List;

import com.shop.model.ItemsCustom;
import com.shop.model.ItemsQueryVo;

/**
 * @author Jeff E-mail:Jeff@ProTest.com
 * @version 创建时间：2017年3月15日 下午10:43:58
 * 类说明
 */
public interface ItemsService {

	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;

	//根据ID查询商品信息
	public ItemsCustom findItemsById(int id)throws Exception;

	//修改商品信息
	public void updateItems(int id ,ItemsCustom itemsCustom)throws Exception;
	
}
