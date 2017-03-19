package com.shop.model;

import java.util.List;

/**
 * @author Jeff E-mail:Jeff@ProTest.com
 * @version 创建时间：2017年3月15日 下午10:06:33
 * 类说明
 * 商品包装对象
 */
public class ItemsQueryVo {

	//商品信息
	private Items items;

	//拓展
	private ItemsCustom itemsCustom;

	//批量商品信息
	private List<ItemsCustom> itemsList;

	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}

	//用户拓展
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemscustom) {
		this.itemsCustom = itemscustom;
	}
}
