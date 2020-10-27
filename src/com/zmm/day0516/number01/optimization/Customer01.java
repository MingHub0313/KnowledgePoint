package com.zmm.day0516.number01.optimization;

import com.zmm.day0516.enums.DoubleEnum;
import com.zmm.day0516.enums.IntegerEnum;
import com.zmm.day0516.number01.Movie;
import com.zmm.day0516.number01.Rental;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Name Customer01 优化 Customer 顾客
 * @Author 900045
 * @Created by 2020/5/16 0016
 */
public class Customer01 {

	/**
	 * 姓名
	 */
	private String name;


	/**
	 * 租借记录
	 */
	private Vector rentals = new Vector();

	public Customer01(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private void addRental(Rental rental){
		rentals.addElement(rental);
	}


	private double amountFor(Rental rental){
		return rental.getCharge();
	}

	/**

	 * 	分解并重组 statement() 方法
	 * @return
	 */
	public String statement(){
		//总消费金额
		double totalAmount = DoubleEnum.NUMBER_0.getNumber();
		//常客积分
		int frequentRenterPoints = IntegerEnum.NUMBER_0.getNumber();

		Enumeration elements = rentals.elements();

		String result = "Rental Record for " + getName() + "\n";

		while (elements.hasMoreElements()){
			// 取得 一笔租借记录
			Rental each = (Rental) elements.nextElement();

			// add frequent renter point (累加 常客积点)
			frequentRenterPoints ++;
			if ((each.getMovie().getPriceCode())== Movie.NEW_RELEASE && each.getDaysRented()>1){
				frequentRenterPoints ++;
			}

			// show figures for this rental (显示此笔租借数据)
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";

			totalAmount += each.getCharge();

		}

		// add footer lines (结尾打印)

		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";

		result += "You earned " + String.valueOf(frequentRenterPoints) + "frequent renter points" ;

		return result;
	}

	/**
	 * 计算一笔租片费用 --易名
	 * 好的代码块应该清楚表达出自己的功能 变量名称是代码清晰的关键.如果为了提高代码的清晰度,需要修改某些东西的名字
	 *
	 *
	 * 问题 : 函数被放错位置 绝大数情况下,函数应该放在它所使用的数据的所属object(class)内,所以 amountFor() 应该移到 Rental 类中
	 * @param aRental
	 * @return
	 */
	// ... amountFor() 应该移到 Rental 类中

}
