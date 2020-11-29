package PoetryCount;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Poetry {
    // ����һ��poetry����������һ��String���͵��ļ�·�����ļ���������һ��String���͵�ֵ
    public static String poetry(String fileName) {
        // ����һ��Scanner��������ڽ��ռ�������
        Scanner scanner = new Scanner(System.in);
        // ����Ҫ�������ַ�
        // ˵����Java��Scanner����û��ֱ�Ӷ�ȡһ���ַ��ķ����������ȶ�ȡһ���ַ�����ȡ���һ���ַ����ɡ�
        System.out.print("������Ҫͳ�Ƶ��ַ�:");
        char myChar = scanner.nextLine().charAt(0);
        // ������
        int count = 0;
        Reader fileInputStream = null;
        String res = null;
        try {
            // ��FileReader����ļ����ж�ȡ����Ϊ��ȡ���ļ������ģ������ƶ���ȡ���ַ�������ΪUTF-8
            fileInputStream = new FileReader(fileName);
            int readData = 0;
            // ����ֽڶ�ȡ�����ĵ�������ʱ��read()��������-1��ѭ������
            while ((readData = fileInputStream.read()) != -1) {
                // ����ֱ�ӱȽϵ���UTF-8ֵ��char���͵�myChar��������һ����ʽ����ת��
                // ���UTF-8ֵ��ͬ���������count++
                if (readData == myChar) count++;
            }
            // �ַ���ƴ�ӣ�myChar��������ַ���count���ַ�������ƴ�Ӻ����·�����
            res = myChar + "���ַ�����Ϊ: " + count;
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            // ��finally���йر���
            if (fileInputStream != null) {
                try {
                    scanner.close();
                    fileInputStream.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // ����res�ַ���
        return res;
    }
}

