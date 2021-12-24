package com.zmm.day0516.enums;

/**
 * @Name IntegerEnum
 * @Author 900045
 * @Created by 2020/5/18 0018
 */
public enum IntegerEnum {

    NUMBER_0(0),
    NUMBER_1(1),
    NUMBER_2(2),
    NUMBER_3(3),
    ;
    private Integer number;

    IntegerEnum(Integer number) {
        this.number = number;

    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
