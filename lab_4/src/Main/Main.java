package Main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import Poem.Poem;
import PoetryCount.Poetry;

public class Main {
    public static void main(String[] args) throws IOException {
        // 实例化学生类
        Student stu = new Student();
        // 创建一个Scanner类对象用于接收键盘输入的学生基本信息
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的名字:");
        String name = scanner.nextLine();
        stu.setName(name);
        System.out.print("请输入你的性别:");
        String gender = scanner.nextLine();
        stu.setGender(gender);
        System.out.print("请输入你的年龄:");
        int age = scanner.nextInt();
        stu.setAge(age);
        String path = "C:Users\\dell\\Desktop\\长恨歌.txt";
        // 调用Poem包里的poems方法，并用一个变量保存起来
        StringBuilder poem = Poem.poems(path);
        String content = "姓名:" + stu.getName() + "\n性别:" + stu.getGender() + "\n年龄:" + stu.getAge() + "\n\n" + poem;
        try(Writer writer = new FileWriter("C:\\Users\\dell\\Desktop\\A.txt")) {
            writer.write(content);
        }
        // 调用Poetry包里的poetry方法，统计字符个数并打印出来
        String res = Poetry.poetry(path);
        System.out.println(res);
        System.out.println("数据已成功写入A.txt文件！");
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

