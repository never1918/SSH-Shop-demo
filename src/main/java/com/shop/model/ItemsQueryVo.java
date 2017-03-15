package com.shop.model;
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
	private ItemsCustom itemscustom;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemscustom() {
		return itemscustom;
	}

	public void setItemscustom(ItemsCustom itemscustom) {
		this.itemscustom = itemscustom;
	}
}
