package com.fj.damain;

public class Goods {
	private Integer id;
	private String goodsName;
	private Float pice;
	//定义一个类型变量来指定这个商品所属的类型
	private TypeGoods typeGoods;
	public Goods(Integer id, String goodsName, Float pice, TypeGoods typeGoods) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.pice = pice;
		this.typeGoods = typeGoods;
	}
	
	public Goods() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Float getPice() {
		return pice;
	}

	public void setPice(Float pice) {
		this.pice = pice;
	}

	public TypeGoods getTypeGoods() {
		return typeGoods;
	}

	public void setTypeGoods(TypeGoods typeGoods) {
		this.typeGoods = typeGoods;
	}
	
	
}
