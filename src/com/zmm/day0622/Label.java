package com.zmm.day0622;

import java.io.Serializable;

/**
 * @Name Label
 * @Author 900045
 * @Created by 2020/6/22 0022
 */
public class Label implements Serializable {

	/**  */
	private static final long serialVersionUID = 1730376790622292958L;
	/**
	 * 标签编号
	 */
	private Integer           labelId;
	/**
	 * 标签名称
	 */
	private String   labelName;

	/**
	 * 标签分类
	 */
	private Integer           categoryId;

	private Integer           sortnum;

	/**
	 * 标签图片Id
	 */
	private Integer           labelImgId;

	/**
	 * 标签图片路径
	 */
	private String            labelImgUrl;

	/**
	 * 伪删除字段.0:删除，1正常
	 */
	private short    isDel;

	public Integer getLabelId() {
		return labelId;
	}

	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getSortnum() {
		return sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	public short getIsDel() {
		return isDel;
	}

	public void setIsDel(short isDel) {
		this.isDel = isDel;
	}

	public Integer getLabelImgId() {
		return labelImgId;
	}

	public void setLabelImgId(Integer labelImgId) {
		this.labelImgId = labelImgId;
	}

	public String getLabelImgUrl() {
		return labelImgUrl;
	}

	public void setLabelImgUrl(String labelImgUrl) {
		this.labelImgUrl = labelImgUrl;
	}

	public Label() {
	}

	public Label(String labelName, Integer categoryId) {
		this.labelName = labelName;
		this.categoryId = categoryId;
	}
}
