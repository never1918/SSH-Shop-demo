package com.shop.dao;

import java.util.List;

import com.shop.model.ItemsCustom;
import com.shop.model.ItemsQueryVo;

/**
 * @author Jeff E-mail:Jeff@ProTest.com
 * @version 创建时间：2017年3月15日 下午10:41:14
 * 类说明
 */
public interface ItemsMapperCustom {
	
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;

}
