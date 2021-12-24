package com.zmm.day0702;

/**
 * @Name GameLauncher
 * @Author 900045
 * @Created by 2020/7/2 0002
 */
public class GameLauncher {

    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        game.startGame();
    }

    /**
     * 创建对象时,它会被存放在称为堆的内存区域中。不管对象如何创建都会放在此区域中。
     * 此区域并非普通的堆；它是可回收垃圾的堆(Garbage-CollectibleНeap) .
     * Java据对 的大小来分配内存空间。
     * 比如说15个实例变量的对象所占用的空间就可能会比只有两个实例变量的对象要大。
     * 但对象使用完毕时内存要如何回收呢?
     * Java会主动帮你管理内存!当某个对象被Javaf拟机察觉不再会被使用到,该对象就会被标记成可回收的。
     * 如果内存开始不足,垃圾收集器就会启动来清理垃圾、回收空间,让空间能够再次被利用.
     */
}
