package com.zmm.day0516.number01;

import com.zmm.day0516.enums.DoubleEnum;
import com.zmm.day0516.enums.IntegerEnum;

/**
 * @Name Rental 租赁
 * @Author 900045
 * @Created by 2020/5/16 0016
 */
public class Rental{

	/**
	 * 影片
	 */
	private Movie movie;

	/**
	 * 租期
	 */
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}

	/**
	 * 针对 Customer01 的优化 添加的函数
	 *
	 * 新需求
	 *  运用多态 取代与价格相关的条件逻辑
	 *  问题 出现的第一部分是 switch 语句 ,在另一个对象的属性基础上运用 switch 语句,并不是什么好主意.
	 *  如果不得不使用,也应该在对象自己的数据上使用 ,而不是在别人的数据上使用  ===> 暗示 getCharge() 应该移动到 Movie 类中
	 * @return
	 */
	public double getCharge(){
		double result = DoubleEnum.NUMBER_0.getNumber();
		switch (movie.getPriceCode()){
			// 普通片
			case Movie.REGULAR:
				result += DoubleEnum.NUMBER_2.getNumber();
				if (getDaysRented()> IntegerEnum.NUMBER_2.getNumber()){
					result += (getDaysRented()-IntegerEnum.NUMBER_2.getNumber()) * DoubleEnum.NUMBER_1_5.getNumber();
				}
				break;
			// 新片
			case Movie.NEW_RELEASE:
				result += getDaysRented()*IntegerEnum.NUMBER_3.getNumber();
				break;
			//儿童片
			case Movie.CHILD_SLICE:
				result += DoubleEnum.NUMBER_1_5.getNumber();
				if (getDaysRented()>IntegerEnum.NUMBER_3.getNumber()){
					result += (getDaysRented()-IntegerEnum.NUMBER_3.getNumber()) * DoubleEnum.NUMBER_1_5.getNumber();
				}
				break;
		}
		return result;
	}


	/**
	 * 针对 Customer02的优化 常客积点计算
	 * @return
	 */
	public int getFrequentRenterPoints(){
		if ((getMovie().getPriceCode())== Movie.NEW_RELEASE && getDaysRented()>IntegerEnum.NUMBER_1.getNumber()){
			return  IntegerEnum.NUMBER_2.getNumber();
		} else {
			return IntegerEnum.NUMBER_1.getNumber();
		}
	}
}
