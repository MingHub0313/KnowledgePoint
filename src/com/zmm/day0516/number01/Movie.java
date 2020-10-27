package com.zmm.day0516.number01;

/**
 * @Name Movie 影片
 * @Author 900045
 * @Created by 2020/5/16 0016
 */
public class Movie {

	public static final int CHILD_SLICE = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;


	/**
	 * 名称
	 */
	private String title ;


	/**
	 * 价格(代号)
	 */
	private int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}
}
