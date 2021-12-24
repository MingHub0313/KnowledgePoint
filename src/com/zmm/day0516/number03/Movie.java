package com.zmm.day0516.number03;

import com.zmm.day0516.enums.IntegerEnum;
import com.zmm.day0516.number01.optimization.Movie03;

/**
 * @Name Movie
 * @Author 900045
 * @Created by 2020/5/20 0020
 */
public class Movie {

    public static final int CHILD_SLICE = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;


    /**
     * 名称
     */
    private String title;


    /**
     * 价格(代号)
     */
    //private int priceCode

    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        //这就是一个set method
        setPriceCode(priceCode);
        //this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    /**
     * 设定价格
     *
     * @param arg
     */
    public void setPriceCode(int arg) {
        switch (arg) {
            // 普通片
            case Movie.REGULAR:
                price = new RegularPrice();
                break;
            // 新片
            case Movie.NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            //儿童片
            case Movie.CHILD_SLICE:
                price = new ChildrenPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }

}
