package PoetryCount;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Poetry {
    // 定义一个poetry方法，接收一个String类型的文件路径或文件名，返回一个String类型的值
    public static String poetry(String fileName) {
        // 创建一个Scanner类对象用于接收键盘输入
        Scanner scanner = new Scanner(System.in);
        // 接收要计数的字符
        // 说明：Java的Scanner类中没有直接读取一个字符的方法，我们先读取一个字符串再取其第一个字符即可。
        System.out.print("请输入要统计的字符:");
        char myChar = scanner.nextLine().charAt(0);
        // 计数器
        int count = 0;
        Reader fileInputStream = null;
        String res = null;
        try {
            // 用FileReader类对文件进行读取，因为读取的文件是中文，所以制定读取的字符集类型为UTF-8
            fileInputStream = new FileReader(fileName);
            int readData = 0;
            // 逐个字节读取，当文档被读完时，read()方法返回-1，循环结束
            while ((readData = fileInputStream.read()) != -1) {
                // 这里直接比较的是UTF-8值，char类型的myChar变量做了一个隐式类型转换
                // 如果UTF-8值相同，则计数器count++
                if (readData == myChar) count++;
            }
            // 字符串拼接，myChar是输入的字符，count是字符个数，拼接好在下方返回
            res = myChar + "的字符个数为: " + count;
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 在finally块中关闭流
            if (fileInputStream != null) {
                try {
                    scanner.close();
                    fileInputStream.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 返回res字符串
        return res;
    }
}

