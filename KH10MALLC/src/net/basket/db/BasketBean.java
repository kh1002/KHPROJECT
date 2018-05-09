package net.basket.db;

import java.util.Date;

public class BasketBean {
	
	private int BASKET_NUM;
	private String BASKET_MEMBER_ID;
	private int BASKET_GOODS_NUM;
	private int BASKET_GOODS_AMOUNT;
	private String BASKET_GOODS_SIZE;
	private String BASKET_GOODS_COLOR;
	private Date BASKET_DATE;
	
	
	public int getBASKET_NUM() {
		return BASKET_NUM;
	}
	public void setBASKET_NUM(int bASKET_NUM) {
		BASKET_NUM = bASKET_NUM;
	}
	public String getBASKET_MEMBER_ID() {
		return BASKET_MEMBER_ID;
	}
	public void setBASKET_MEMBER_ID(String bASKET_MEMBER_ID) {
		BASKET_MEMBER_ID = bASKET_MEMBER_ID;
	}
	public int getBASKET_GOODS_NUM() {
		return BASKET_GOODS_NUM;
	}
	public void setBASKET_GOODS_NUM(int bASKET_GOODS_NUM) {
		BASKET_GOODS_NUM = bASKET_GOODS_NUM;
	}
	public int getBASKET_GOODS_AMOUNT() {
		return BASKET_GOODS_AMOUNT;
	}
	public void setBASKET_GOODS_AMOUNT(int bASKET_GOODS_AMOUNT) {
		BASKET_GOODS_AMOUNT = bASKET_GOODS_AMOUNT;
	}
	public String getBASKET_GOODS_SIZE() {
		return BASKET_GOODS_SIZE;
	}
	public void setBASKET_GOODS_SIZE(String bASKET_GOODS_SIZE) {
		BASKET_GOODS_SIZE = bASKET_GOODS_SIZE;
	}
	public String getBASKET_GOODS_COLOR() {
		return BASKET_GOODS_COLOR;
	}
	public void setBASKET_GOODS_COLOR(String bASKET_GOODS_COLOR) {
		BASKET_GOODS_COLOR = bASKET_GOODS_COLOR;
	}
	public Date getBASKET_DATE() {
		return BASKET_DATE;
	}
	public void setBASKET_DATE(Date bASKET_DATE) {
		BASKET_DATE = bASKET_DATE;
	}
	
	
	
	

}
