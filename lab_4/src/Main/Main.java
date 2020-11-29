package Main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import Poem.Poem;
import PoetryCount.Poetry;

public class Main {
    public static void main(String[] args) throws IOException {
        // ʵ����ѧ����
        Student stu = new Student();
        // ����һ��Scanner��������ڽ��ռ��������ѧ��������Ϣ
        Scanner scanner = new Scanner(System.in);
        System.out.print("�������������:");
        String name = scanner.nextLine();
        stu.setName(name);
        System.out.print("����������Ա�:");
        String gender = scanner.nextLine();
        stu.setGender(gender);
        System.out.print("�������������:");
        int age = scanner.nextInt();
        stu.setAge(age);
        String path = "C:Users\\dell\\Desktop\\���޸�.txt";
        // ����Poem�����poems����������һ��������������
        StringBuilder poem = Poem.poems(path);
        String content = "����:" + stu.getName() + "\n�Ա�:" + stu.getGender() + "\n����:" + stu.getAge() + "\n\n" + poem;
        try(Writer writer = new FileWriter("C:\\Users\\dell\\Desktop\\A.txt")) {
            writer.write(content);
        }
        // ����Poetry�����poetry������ͳ���ַ���������ӡ����
        String res = Poetry.poetry(path);
        System.out.println(res);
        System.out.println("�����ѳɹ�д��A.txt�ļ���");
    }
}

class Student{
    private String name;
    private String gender;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }
}

