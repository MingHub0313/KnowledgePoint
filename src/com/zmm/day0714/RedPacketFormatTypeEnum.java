package com.zmm.day0714;

/**
 * @Name RedPacketFormatTypeEnum
 * @Author 900045
 * @Created by 2020/7/15 0015
 */
public enum RedPacketFormatTypeEnum {

    NO_LEFT(1, "红包总额 = 预算总额：金额不允许有剩余"),
    CAN_LEFT(2, "红包总额 <= 预算总额：金额允许有剩余");

    public int code;
    public String name;

    RedPacketFormatTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

}
