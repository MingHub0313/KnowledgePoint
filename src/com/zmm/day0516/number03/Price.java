package com.zmm.day0516.number03;

import com.zmm.day0516.enums.IntegerEnum;
import com.zmm.day0516.number01.optimization.Movie03;

/**
 * @Name Price
 * @Author 900045
 * @Created by 2020/5/20 0020
 */
public abstract class Price {

	/**
	 * 取得价格代码
	 * @return
	 */
	abstract int getPriceCode();

	/**
	 * 计算
	 * @param daysRented
	 * @return
	 */
	abstract double getCharge(int daysRented);

	/**
	public int getFrequentRenterPoints(int daysRented){
		if ((getPriceCode())== Movie.NEW_RELEASE && daysRented> IntegerEnum.NUMBER_1.getNumber()){
			return  IntegerEnum.NUMBER_2.getNumber();
		} else {
			return IntegerEnum.NUMBER_1.getNumber();
		}
	}
	 */

	int getFrequentRenterPoints(int daysRented){
		return IntegerEnum.NUMBER_1.getNumber();
	}

	/**
	public double getCharge(int daysRented){
		double result = DoubleEnum.NUMBER_0.getNumber();
		switch (getPriceCode()){
			// 普通片
			case Movie.REGULAR:
				result += DoubleEnum.NUMBER_2.getNumber();
				if (daysRented> IntegerEnum.NUMBER_2.getNumber()){
					result += (daysRented-IntegerEnum.NUMBER_2.getNumber()) * DoubleEnum.NUMBER_1_5.getNumber();
				}
				break;
			// 新片
			case Movie.NEW_RELEASE:
				result += daysRented*IntegerEnum.NUMBER_3.getNumber();
				break;
			//儿童片
			case Movie.CHILD_SLICE:
				result += DoubleEnum.NUMBER_1_5.getNumber();
				if (daysRented>IntegerEnum.NUMBER_3.getNumber()){
					result += (daysRented-IntegerEnum.NUMBER_3.getNumber()) * DoubleEnum.NUMBER_1_5.getNumber();
				}
				break;
		}
		return result;
	}
	 */
}
