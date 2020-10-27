package com.zmm.day0516.number01.optimization;

import com.zmm.day0516.enums.DoubleEnum;
import com.zmm.day0516.enums.IntegerEnum;

/**
 * @Name Movie03
 * @Author 900045
 * @Created by 2020/5/16 0016
 */
public class Movie03 {

	public static final String CHILD_SLICE = "2";
	public static final String REGULAR = "0";
	public static final String NEW_RELEASE = "1";


	/**
	 * 名称
	 */
	private String title ;


	/**
	 * 价格(代号)
	 */
	private String priceCode;

	public Movie03(String title, String priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}


	/**
	 * 从 Rental 类中 移来
	 * 为了 它得以运作,我必须把 [租期长度] 作为参数传递进去.当然[租期长度] 来自 Rental 对象
	 * 计算费用时需要两份数据 [租期长度] 和 [影片类型]
	 * 为什么 我选择 [将租期长度传递给 Movie 对象] 而不是[将影片类型传递给 Rental对象]
	 *
	 * 因为系统可能发生的变化是加入新影片类型买这种变化带有不稳定倾向.
	 * 如果影片类型有所变化 我希望掀起最小的涟漪,所以我选择在 Movie 对象内计算费用
	 * @param daysRented
	 * @return
	 */
	public double getCharge(int daysRented){
		double result = DoubleEnum.NUMBER_0.getNumber();
		switch (getPriceCode()){
			// 普通片
			case Movie03.REGULAR:
				result += DoubleEnum.NUMBER_2.getNumber();
				if (daysRented>IntegerEnum.NUMBER_2.getNumber()){
					result += (daysRented-IntegerEnum.NUMBER_2.getNumber()) * DoubleEnum.NUMBER_1_5.getNumber();
				}
				break;
			// 新片
			case Movie03.NEW_RELEASE:
				result += daysRented*IntegerEnum.NUMBER_3.getNumber();
				break;
			//儿童片
			case Movie03.CHILD_SLICE:
				result += DoubleEnum.NUMBER_1_5.getNumber();
				if (daysRented>IntegerEnum.NUMBER_3.getNumber()){
					result += (daysRented-IntegerEnum.NUMBER_3.getNumber()) * DoubleEnum.NUMBER_1_5.getNumber();
				}
				break;
		}
		return result;
	}


	/**
	 * 将Rental04 中的 getFrequentRenterPoints 计算 移到  Movie03 中
	 * @param daysRented
	 * @return
	 */
	public int getFrequentRenterPoints(int daysRented){
		if ((getPriceCode())== Movie03.NEW_RELEASE && daysRented> IntegerEnum.NUMBER_1.getNumber()){
			return  IntegerEnum.NUMBER_2.getNumber();
		} else {
			return IntegerEnum.NUMBER_1.getNumber();
		}
	}

}
