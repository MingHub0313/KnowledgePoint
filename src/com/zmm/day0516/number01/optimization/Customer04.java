package com.zmm.day0516.number01.optimization;


import com.zmm.day0516.enums.DoubleEnum;
import com.zmm.day0516.enums.IntegerEnum;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Name Customer04
 * @Author 900045
 * @Created by 2020/5/16 0016
 */
public class Customer04 {

    /**
     * 姓名
     */
    private String name;


    /**
     * 租借记录
     */
    private Vector rentals = new Vector();

    public Customer04(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void addRental(Rental04 rental) {
        rentals.addElement(rental);
    }


    private double amountFor(Rental04 rental) {
        return rental.getCharge();
    }

    /**
     * 分解并重组 statement() 方法
     *
     * @return
     */
    public String statement() {
        Enumeration elements = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (elements.hasMoreElements()) {
            // 取得 一笔租借记录
            Rental04 each = (Rental04) elements.nextElement();
            // show figures for this rental (显示此笔租借数据)
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";

        }

        // add footer lines (结尾打印)
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";

        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + "frequent renter points";

        return result;
    }

    /**
     * @return
     */
    private double getTotalCharge() {
        double result = DoubleEnum.NUMBER_0.getNumber();
        Enumeration elements = rentals.elements();
        while (elements.hasMoreElements()) {
            Rental04 each = (Rental04) elements.nextElement();
            result += each.getCharge();
        }
        return result;
    }


    /**
     * @return
     */
    private int getTotalFrequentRenterPoints() {
        int result = IntegerEnum.NUMBER_0.getNumber();
        Enumeration elements = rentals.elements();
        while (elements.hasMoreElements()) {
            Rental04 each = (Rental04) elements.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    /**
     * 计算一笔租片费用 --易名
     * 好的代码块应该清楚表达出自己的功能 变量名称是代码清晰的关键.如果为了提高代码的清晰度,需要修改某些东西的名字
     * <p>
     * <p>
     * 问题 : 函数被放错位置 绝大数情况下,函数应该放在它所使用的数据的所属object(class)内,所以 amountFor() 应该移到 Rental 类中
     *
     * @param
     * @return
     */
    // ... amountFor() 应该移到 Rental 类中

    // ---重构之后添加功能
    public String htmlStatement() {
        Enumeration elements = rentals.elements();
        String result = "<H1>Rental for <EM>" + getName() + "</EM></H1><P>\n";

        while (elements.hasMoreElements()) {
            // 取得 一笔租借记录
            Rental04 each = (Rental04) elements.nextElement();
            // show figures for this rental (显示此笔租借数据)
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "<BR>\n";

        }

        // add footer lines (结尾打印)
        result += "<P> You owed <EM> " + String.valueOf(getTotalCharge()) + "</EM><P>\n";

        result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM>frequent renter points<P>";

        return result;
    }
}
