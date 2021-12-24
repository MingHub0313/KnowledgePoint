package com.zmm.day0714;

import java.io.Serializable;

/**
 * @Name RedPacketConfig
 * @Author 900045
 * @Created by 2020/7/16 0016
 */
public class RedPacketConfig implements Serializable {


    /**
     * 总金额
     */
    private Double totalMoney;

    /**
     * 红包数量
     */
    private Integer number;

    /**
     * 随机红包最小值
     */
    private Double minMoney;


    /**
     * 随机红包最大值
     */
    private Double maxMoney;

    /**
     * 修数据方式：1.红包总额 = 预算总额；2.红包总额 <= 预算总额
     */
    private RedPacketFormatTypeEnum formatType;

    /**
     * 预算剩余金额
     */
    private Double leftMoney;

    public RedPacketConfig() {
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(Double minMoney) {
        this.minMoney = minMoney;
    }

    public Double getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(Double maxMoney) {
        this.maxMoney = maxMoney;
    }

    public RedPacketFormatTypeEnum getFormatType() {
        return formatType;
    }

    public void setFormatType(RedPacketFormatTypeEnum formatType) {
        this.formatType = formatType;
    }

    public Double getLeftMoney() {
        return leftMoney;
    }

    public void setLeftMoney(Double leftMoney) {
        this.leftMoney = leftMoney;
    }
}
