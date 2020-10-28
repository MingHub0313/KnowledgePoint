package com.base.page29;

import org.junit.Test;

import java.io.*;

/**
 * @Name ReadByteTest
 * @Author 18057
 * @Createed 17:04 2020/10/28
 * @Description 按字节读取文件内容  按字符读取文件内容   按行读取文件内容   随机读取文件内容
 * @Version 0.0.1
 */
public class ReadByteTest {

    /**
     * 以字节为单位读取文件 常用于读二进制文件 如图片、声音、影像等文件.
     */

    @Test
    public void test(){

        String fileName = "F:\\study_java\\KnowledgePoint\\resources\\newTemp.txt.txt";
        //readFileByBytes(fileName);
        //readFileByChars(fileName);
        //readFileByLines(fileName);
        readFileByRandomAccess(fileName);

    }

    public static void readFileByBytes(String fileName) {
        long startTime = System.currentTimeMillis();
        System.out.println("第一次开始时间:"+startTime);
        File file = new File(fileName);
        InputStream in = null;
        try {
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            // 一次读一个字节
            in = new FileInputStream(file);
            int tempByte;
            while ((tempByte = in.read()) != -1) {
                System.out.write(tempByte);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        long midTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("第一次结束时间(第二次开始时间):"+midTime);
        System.out.println("一次读一个字节 一共花费时间:"+ (midTime-startTime));
        try {
            System.out.println("================");
            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
            // 一次读多个字节
            byte[] tempBytes = new byte[100];
            int byteRead = 0;
            in = new FileInputStream(fileName);
            ReadFromFile.showAvailableBytes(in);
            // 读入多个字节到字节数组中，byteRead为一次读入的字节数
            while ((byteRead = in.read(tempBytes)) != -1) {
                System.out.write(tempBytes, 0, byteRead);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("第二次结束时间:"+endTime);
        System.out.println("一次读多个字节 一共花费时间:"+(endTime-midTime));

    }

    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */
    public static void readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempChar;
            while ((tempChar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempChar) != '\r') {
                    System.out.print((char) tempChar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("================");
            System.out.println("以字符为单位读取文件内容，一次读多个字节：");
            // 一次读多个字符
            char[] tempChars = new char[30];
            int charRead = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            // 读入多个字符到字符数组中，charRead为一次读取字符数
            while ((charRead = reader.read(tempChars)) != -1) {
                // 同样屏蔽掉\r不显示
                if ((charRead == tempChars.length)
                        && (tempChars[tempChars.length - 1] != '\r')) {
                    System.out.print(tempChars);
                } else {
                    for (int i = 0; i < charRead; i++) {
                        if (tempChars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempChars[i]);
                        }
                    }
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }


    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 随机读取文件内容
     */
    public static void readFileByRandomAccess(String fileName) {
        RandomAccessFile randomFile = null;
        try {
            System.out.println("随机读取一段文件内容：");
            // 打开一个随机访问文件流，按只读方式
            randomFile = new RandomAccessFile(fileName, "r");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 读文件的起始位置
            int beginIndex = (fileLength > 4) ? 4 : 0;
            // 将读文件的开始位置移到beginIndex位置。
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteRead = 0;
            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
            // 将一次读取的字节数赋给byteRead
            while ((byteRead = randomFile.read(bytes)) != -1) {
                System.out.write(bytes, 0, byteRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e1) {
                }
            }
        }
    }

}
