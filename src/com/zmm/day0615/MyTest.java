package com.zmm.day0615;


import java.util.HashMap;

/**
 * @Name MyTest
 * @Author 900045
 * @Created by 2020/6/15 0015
 */
public class MyTest {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap(16);

        myHashMap.put("1号", "1号");
        myHashMap.put("2号", "2号");
        myHashMap.put("3号", "3号");
        myHashMap.put("4号", "4号");
        myHashMap.put("5号", "5号");
        myHashMap.put("6号", "6号");
        myHashMap.put("7号", "7号");
        myHashMap.put("8号", "8号");
        myHashMap.put("9号", "9号");
        myHashMap.put("10号", "10号");
        myHashMap.put("11号", "11号");
        myHashMap.put("12号", "12号");
        myHashMap.put("13号", "13号");
        myHashMap.put("14号", "14号");
        myHashMap.put("15号", "15号");
        myHashMap.put("16号", "16号");
        myHashMap.put("17号", "17号");
        myHashMap.put("18号", "18号");
        myHashMap.put("19号", "19号");
        myHashMap.put("20号", "20号");
        myHashMap.put("21号", "21号");
        myHashMap.put("22号", "22号");
        myHashMap.put("23号", "23号");
        myHashMap.put("24号", "24号");
        myHashMap.put("25号", "25号");
        myHashMap.put("26号", "26号");
        myHashMap.put("27号", "27号");
        myHashMap.put("28号", "28号");
        myHashMap.put("28号", "28号");
        myHashMap.put("29号", "29号");
        myHashMap.put("30号", "30号");
        myHashMap.put("31号", "31号");
        myHashMap.put("32号", "32号");
        myHashMap.put("33号", "33号");
        System.out.println("------------------------------");

        System.out.println("是否为空" + myHashMap.isEmpty());
        myHashMap.put(null, "幼稚");
        System.out.println("打印" + myHashMap.toString());
        System.out.println("1----是否存在某键" + myHashMap.containsValue("10号"));
        System.out.println("2----是否存在某值" + myHashMap.containsKey("33号"));
        System.out.println("3----是否存在某键" + myHashMap.containsValue("33号"));
        System.out.println("4----是否存在某值" + myHashMap.containsKey("10号"));
        //myHashMap.put("33号","45号")
        System.out.println("5----是否存在某键" + myHashMap.containsValue("45号"));
        System.out.println("6----是否存在某值" + myHashMap.containsKey(null));
        System.out.println("7----是否存在某键" + myHashMap.containsValue(null));
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.get("28号"));
        System.out.println(myHashMap.get(null));
        System.out.println("-----------清空-------------------");
        myHashMap.clear();
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.get("28号"));

    }
}
