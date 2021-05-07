package com.zmm;

import java.util.ArrayList;
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

        ArrayList arrayList = new ArrayList(5);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(8);

        System.out.println("使用 [add] 方法后的size:===========>"+arrayList.size());

        System.out.println("使用 [get] 方法得到的元素:===========>"+arrayList.get(2));

        arrayList.set(3,10);
        System.out.println("使用 [set] 方法后的size:===========>"+arrayList.size());
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
