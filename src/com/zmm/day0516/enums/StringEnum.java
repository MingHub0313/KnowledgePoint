package com.zmm.day0516.enums;

/**
 * @Name StringEnum
 * @Author 900045
 * @Created by 2020/5/18 0018
 */
public enum StringEnum {

	STRING_0("0"),
	STRING_1("1"),
	STRING_2("2"),
	STRING_3("3"),
	;
	private String    str;

	StringEnum(String str) {
		this.str = str;

	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
