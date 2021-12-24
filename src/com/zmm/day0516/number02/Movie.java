package com.zmm.day0516.number02;

import com.zmm.day0516.enums.DoubleEnum;
import com.zmm.day0516.enums.IntegerEnum;
import com.zmm.day0516.number01.optimization.Movie03;

/**
 * @Name Movie
 * @Author 900045
 * @Created by 2020/5/20 0020
 */
public class Movie {

    public static final String CHILD_SLICE = "2";
    public static final String REGULAR = "0";
    public static final String NEW_RELEASE = "1";


    /**
     * 名称
     */
    private String title;


    /**
     * 价格(代号)
     */
    private String priceCode;

    public Movie(String title, String priceCode) {
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

    public double getCharge(int daysRented) {
        double result = DoubleEnum.NUMBER_0.getNumber();
        switch (getPriceCode()) {
            // 普通片
            case Movie.REGULAR:
                result += DoubleEnum.NUMBER_2.getNumber();
                if (daysRented > IntegerEnum.NUMBER_2.getNumber()) {
                    result += (daysRented - IntegerEnum.NUMBER_2.getNumber()) * DoubleEnum.NUMBER_1_5.getNumber();
                }
                break;
            // 新片
            case Movie.NEW_RELEASE:
                result += daysRented * IntegerEnum.NUMBER_3.getNumber();
                break;
            //儿童片
            case Movie.CHILD_SLICE:
                result += DoubleEnum.NUMBER_1_5.getNumber();
                if (daysRented > IntegerEnum.NUMBER_3.getNumber()) {
                    result += (daysRented - IntegerEnum.NUMBER_3.getNumber()) * DoubleEnum.NUMBER_1_5.getNumber();
                }
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode()) == Movie03.NEW_RELEASE && daysRented > IntegerEnum.NUMBER_1.getNumber()) {
            return IntegerEnum.NUMBER_2.getNumber();
        } else {
            return IntegerEnum.NUMBER_1.getNumber();
        }
    }

}
