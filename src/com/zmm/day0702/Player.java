package com.zmm.day0702;

/**
 * @Name Player
 * @Author 900045
 * @Created by 2020/7/2 0002
 */
public class Player {

    int number = 0;

    public void guess() {
        number = (int) (Math.random() * 10);
        System.out.println("I’m guessing " + number);
    }
}
