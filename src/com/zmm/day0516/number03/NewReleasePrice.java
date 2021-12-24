package com.zmm.day0516.number03;

import com.zmm.day0516.enums.IntegerEnum;

/**
 * @Name NewReleasePrice
 * @Author 900045
 * @Created by 2020/5/20 0020
 */
public class NewReleasePrice extends Price {

    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * IntegerEnum.NUMBER_3.getNumber();
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return (daysRented > IntegerEnum.NUMBER_1.getNumber() ? IntegerEnum.NUMBER_2.getNumber() : IntegerEnum.NUMBER_1.getNumber());
    }
}
