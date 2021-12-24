package com.zmm.day0516.number02;

import com.zmm.day0516.enums.DoubleEnum;
import com.zmm.day0516.enums.IntegerEnum;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Name Customer
 * @Author 900045
 * @Created by 2020/5/20 0020
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


    private double amountFor(Rental rental) {
        return rental.getCharge();
    }

    public String statement() {
        Enumeration elements = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (elements.hasMoreElements()) {
            // 取得 一笔租借记录
            Rental each = (Rental) elements.nextElement();
            // show figures for this rental (显示此笔租借数据)
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";

        }

        // add footer lines (结尾打印)
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";

        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + "frequent renter points";

        return result;
    }

    private double getTotalCharge() {
        double result = DoubleEnum.NUMBER_0.getNumber();
        Enumeration elements = rentals.elements();
        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = IntegerEnum.NUMBER_0.getNumber();
        Enumeration elements = rentals.elements();
        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    public String htmlStatement() {
        Enumeration elements = rentals.elements();
        String result = "<H1>Rental for <EM>" + getName() + "</EM></H1><P>\n";

        while (elements.hasMoreElements()) {
            // 取得 一笔租借记录
            Rental each = (Rental) elements.nextElement();
            // show figures for this rental (显示此笔租借数据)
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "<BR>\n";

        }

        // add footer lines (结尾打印)
        result += "<P> You owed <EM> " + String.valueOf(getTotalCharge()) + "</EM><P>\n";

        result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM>frequent renter points<P>";

        return result;
    }


}
