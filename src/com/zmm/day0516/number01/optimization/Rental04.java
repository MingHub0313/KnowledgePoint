package com.zmm.day0516.number01.optimization;



/**
 * @Name Rental04
 * @Author 900045
 * @Created by 2020/5/16 0016
 */
public class Rental04 {


	/**
	 * 影片
	 */
	private Movie03 movie;

	/**
	 * 租期
	 */
	private int daysRented;

	public Rental04(Movie03 movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie03 getMovie() {
		return movie;
	}

	public void setMovie(Movie03 movie) {
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


	/**
	 * 针对 Customer02的优化 常客积点计算
	 * @return
	 */
	public int getFrequentRenterPoints(){
		return movie.getFrequentRenterPoints(daysRented);
	}

	/**
	 * 从 Movie03 中获取
	 * @return
	 */
	public double getCharge(){
		return movie.getCharge(daysRented);
	}
}
