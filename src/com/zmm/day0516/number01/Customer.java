package com.zmm.day0516.number01;

import com.zmm.day0516.enums.DoubleEnum;
import com.zmm.day0516.enums.IntegerEnum;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Name Customer 顾客
 * @Author 900045
 * @Created by 2020/5/16 0016
 */
public class Customer {

    /**
     * 姓名
     */
    private String name;


    /**
     * 租借记录
     */
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    /**
     * 核心逻辑
     * 如果你发现自己需要为程序添加一个特性,而代码结构使你无法很方便地那么做,那就先重构那个程序,使特性的添加比较容易进行,然后再添加特性
     * <p>
     * 每当要进行重构的时候,第一个步骤永远相同 :
     * 我得为即将修改的代码建立一组可靠的测试环境.
     * <p>
     * 分解并重组 statement() 方法
     *
     * @return
     */
    public String statement() {
        //总消费金额
        double totalAmount = DoubleEnum.NUMBER_0.getNumber();
        //常客积分
        int frequentRenterPoints = IntegerEnum.NUMBER_0.getNumber();

        Enumeration elements = rentals.elements();

        String result = "Rental Record for " + getName() + "\n";

        while (elements.hasMoreElements()) {

            double thisAmount = DoubleEnum.NUMBER_0.getNumber();

            // 取得 一笔租借记录
            Rental each = (Rental) elements.nextElement();

            //  ======== 1.1 逻辑泥团 ---->提炼到独立的函数中
            /**
             * 代码块里头找出 函数内的局部 变量 和 参数
             * 本方法中 each 和 thisAmount ,前者并未被修改 , 后者会被修改
             * 如何不会被修改的变量都可以被我当作参数传入新的函数,至于会被修改的变量就就需要格外小心
             * 如果只有一个变量会被修改,我可以把它当作返回值. thisAmount 是临时变量,其值在每次循环起始处被设置为0
             * 并且在 switch 语句之前不会改变 ,所以我可以直接把新函数的返回值赋予它.
             *
             * 见optimization 的  Customer01
             */
            // 取得影片出租价格
            switch (each.getMovie().getPriceCode()) {
                // 普通片
                case Movie.REGULAR:
                    thisAmount += DoubleEnum.NUMBER_2.getNumber();
                    if (each.getDaysRented() > IntegerEnum.NUMBER_2.getNumber()) {
                        thisAmount += (each.getDaysRented() - IntegerEnum.NUMBER_2.getNumber()) * DoubleEnum.NUMBER_1_5.getNumber();
                    }
                    break;
                // 新片
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * IntegerEnum.NUMBER_3.getNumber();
                    break;
                //儿童片
                case Movie.CHILD_SLICE:
                    thisAmount += DoubleEnum.NUMBER_1_5.getNumber();
                    if (each.getDaysRented() > IntegerEnum.NUMBER_3.getNumber()) {
                        thisAmount += (each.getDaysRented() - IntegerEnum.NUMBER_3.getNumber()) * DoubleEnum.NUMBER_1_5.getNumber();
                    }
                    break;
            }

            // add frequent renter point (累加 常客积点)
            frequentRenterPoints++;
            if ((each.getMovie().getPriceCode()) == Movie.NEW_RELEASE && each.getDaysRented() > IntegerEnum.NUMBER_1.getNumber()) {
                frequentRenterPoints++;
            }

            // show figures for this rental (显示此笔租借数据)
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";

            totalAmount += thisAmount;

        }

        // add footer lines (结尾打印)

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";

        result += "You earned " + String.valueOf(frequentRenterPoints) + "frequent renter points";

        return result;
    }
}
