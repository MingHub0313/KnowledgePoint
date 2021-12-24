package com.zmm.day0622;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Name ShareModel
 * @Author 900045
 * @Created by 2020/6/22 0022
 */
public class ShareModel implements Serializable {
    /**
     * spuID
     */
    private Integer spuId;


    /**
     * spu图片ID
     */
    private Integer imgId;

    /**
     * sku图片ID
     */
    private Integer skuImgId;

    /**
     * 商品图片
     */
    private String img;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品卖点
     */
    private String sellPoint;

    /**
     * 原始价格
     */
    private double originPrice;

    /**
     * 用户名
     */
    private String customerName;

    /**
     * 二维码
     */
    private String qrCode;

    /**
     * 跳转链接
     */
    private String shareUrl;

    /**
     * 礼包Id
     *
     * @return
     */
    private Integer giftId;

    /**
     * 商品限购时间
     *
     * @return
     */
    private long ActivityDate;

    /**
     * 特卖状态    0非特卖,预热中: 1  , 限时特卖: 2
     */
    private int specialStatus = 0;

    /**
     * 是否在在用户店铺精选中(0不在  1在)
     *
     * @return
     */
    private int isInUserShop;

    /**
     * 佣金（礼包分享展示）
     *
     * @return
     */
    private double commission;

    /**
     * 商品标签集合
     *
     * @return
     */
    private List<Label> labelList = new ArrayList<>();

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(double originPrice) {
        this.originPrice = originPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getSkuImgId() {
        return skuImgId;
    }

    public void setSkuImgId(Integer skuImgId) {
        this.skuImgId = skuImgId;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public long getActivityDate() {
        return ActivityDate;
    }

    public void setActivityDate(long activityDate) {
        ActivityDate = activityDate;
    }

    public int getSpecialStatus() {
        return specialStatus;
    }

    public void setSpecialStatus(int specialStatus) {
        this.specialStatus = specialStatus;
    }

    public int getIsInUserShop() {
        return isInUserShop;
    }

    public void setIsInUserShop(int isInUserShop) {
        this.isInUserShop = isInUserShop;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public List<Label> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<Label> labelList) {
        this.labelList = labelList;
    }
}
