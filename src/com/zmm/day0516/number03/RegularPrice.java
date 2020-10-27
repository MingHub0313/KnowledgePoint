package com.zmm.day0516.number03;

import com.zmm.day0516.enums.DoubleEnum;
import com.zmm.day0516.enums.IntegerEnum;

/**
 * @Name RegularPrice
 * @Author 900045
 * @Created by 2020/5/20 0020
 */
public class RegularPrice extends Price {


	@Override
	int getPriceCode() {
		return Movie.REGULAR;
	}

	@Override
	double getCharge(int daysRented){
		double result =DoubleEnum.NUMBER_2.getNumber();
		if (daysRented > Movie.REGULAR){
			result +=(daysRented- IntegerEnum.NUMBER_2.getNumber()) * DoubleEnum.NUMBER_1_5.getNumber();
		}
		return  result;
	}

	@Override
	int getFrequentRenterPoints(int daysRented){
		return IntegerEnum.NUMBER_1.getNumber();
	}
}
