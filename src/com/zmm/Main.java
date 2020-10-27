package com.zmm;

import java.util.Calendar;


/**
 * main 入口
 *
 * @Name Main
 * @Author 900059
 * @Created by 2019/11/7 0007
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(getEndTime());
    }

    private static Long getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime().getTime();
    }
}
