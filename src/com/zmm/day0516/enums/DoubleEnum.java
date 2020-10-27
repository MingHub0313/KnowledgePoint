package com.zmm.day0516.enums;

/**
 * @Name DoubleEnum
 * @Author 900045
 * @Created by 2020/5/18 0018
 */
public enum DoubleEnum {

	NUMBER_0(0, "0"),
	NUMBER_1(1, "1"),
	NUMBER_1_5(1.5, "1"),
	NUMBER_2(2, "2"),
	NUMBER_3(3, "2"),
	;
	private double    number;
	private String name;

	DoubleEnum(double number, String name) {
		this.number = number;
		this.name = name;
	}

	public static DoubleEnum getType(int number) {
		if (number <= 0) {
			return null;
		}
		for (DoubleEnum recordType : DoubleEnum.values()) {
			if (recordType.number == number) {
				return recordType;
			}
		}
		return null;
	}

	public static String getName(int number) {
		DoubleEnum assessRecordType = getType(number);
		return assessRecordType == null ? null : assessRecordType.name;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
