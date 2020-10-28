package com.base.page29;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Name ReadFromFile
 * @Author 18057
 * @Createed 17:08 2020/10/28
 * @Description
 * @Version
 */
public class ReadFromFile {

    /**
     * 显示输入流中还剩的字节数
     */
    public static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
