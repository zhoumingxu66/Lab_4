# java第四次试验  计G201 2020322057 周洺旭
# 阅读程序  
## 程序内容
在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。  
文件A包括两部分内容：  
一是学生的基本信息；  
二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：  

每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”  
允许提供输入参数，统计古诗中某个字或词出现的次数  
输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A  
考虑操作中可能出现的异常，在程序中设计异常处理程序  

输入：汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝选在君王侧回眸一笑百媚生六宫粉黛无颜色春寒赐浴华清池温泉水滑洗凝脂侍儿扶起娇无力始是新承恩泽时云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起从此君王不早朝承欢侍宴无闲暇春从春游夜专夜后宫佳丽三千人三千宠爱在一身金屋妆成娇侍夜玉楼宴罢醉和春姊妹弟兄皆列士可怜光采生门户遂令天下父母心不重生男重生女骊宫高处入青云仙乐风飘处处闻缓歌慢舞凝丝竹尽日君王看不足渔阳鼙鼓动地来惊破霓裳羽衣曲九重城阙烟尘生千乘万骑西南行<未完，待续>  
  
输出：  
汉皇重色思倾国，御宇多年求不得。  
杨家有女初长成，养在深闺人未识。  
天生丽质难自弃，一朝选在君王侧。  
回眸一笑百媚生，六宫粉黛无颜色。  
春寒赐浴华清池，温泉水滑洗凝脂。  
侍儿扶起娇无力，始是新承恩泽时。  
云鬓花颜金步摇，芙蓉帐暖度春宵。  
春宵苦短日高起，从此君王不早朝。  
…………
    
### 实验要求：  
1.设计学生类（可利用之前的）；  
2.采用交互式方式实例化某学生；  
3.设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。  

## 实验目的  
1.掌握字符串String及其方法的使用  
2.掌握文件的读取/写入方法  
3.掌握异常处理结构  
  

## 试验过程
1.将本次试验分三个包进行试验处理  
！（https://github.com/zhoumingxu66/Lab_4/blob/main/picture/%E8%AF%95%E9%AA%8C%E7%BB%93%E6%9E%84.png）  
2.Main类中创建一个学生类，在学生类中定义学生的姓名、性别、年龄。并且在Main类中利用scanner方法输入  
调用Poetry包里的poetry方法，统计字符个数并打印出来  
利用io处理将文件创建
```
try(Writer writer = new FileWriter("E:\\360MoveData\\Users\\97568\\Desktop\\java 4\\A.txt"，StandardCharsets.UTF_8)) {
            writer.write(content);
        }
```
```
 String res = Poetry.poetry(path);
        System.out.println(res);
        System.out.println("数据已成功写入A.txt文件！");
```
3.在poem类中对写入的诗进行编写
```
public class Poem {
    // 定义一个poems方法，接收一个String类型的文件名或文件路径，返回一个StringBuilder类型的值，同时捕获IOException
    public static StringBuilder poems(String path) throws IOException {
        // 创建一个String类型的ArrayList数组，用来将诗按格式分好组
        ArrayList<String> strList = new ArrayList<>();
        // content用来保存读取出来的诗
        String content;
        // 用FileReader来操作文件，传入文件路径或文件名，同时制定字符集为UTF-8
        try(Reader reader = new FileReader(path, StandardCharsets.UTF_8)) {
            int n;
            // 由于输出的是char类型的字符，所有定义一个StringBuilder类型的变量来拼接每个字符，使之成为连续的字符串
            StringBuilder sb = new StringBuilder();
            // 逐个字节读取，当文档被读完时，read()方法返回-1，循环结束
            while ((n = reader.read()) != -1) {
                // 用append方法来拼接每个字符
                sb.append((char) n);
            }
            // 将拼接好的字符串转换为String类型并赋值给content
            content = sb.toString();
 ```
 最后利用str用来保存提取出来的每句诗，这时候用for循环将本次试验的诗规定为一行14个字，最后利用换行符“\n”进行拼接。组成为一首完整的诗。
 ```
  for (int i = 1; i < strList.size(); i++) { 
            String s = strList.get(i);
            for (int j = 0; j < s.length(); j++) {
                if (j == 7) {
                    s = s.substring(0, j) + "，" + s.substring(j, s.length()) + "。";
                }
            }
            poem.append(s + "\n");
        }
```
4.在poetry类中主要作用是输入是的内容，利用同样是scanner方法，并且利用 char myChar = scanner.nextLine().charAt(0);该行代码对本首诗进行计数。
## 核心方法  
1.scanner输入方法（注意int tuition = scanner.nextInt();输入条件的判定）
2.io写入输出（import java.io.*;   import java.nio.charset.StandardCharsets;  import java.util.Scanner;）

3.异常报错try{} catch{}
4.
##实验结果
!(https://github.com/zhoumingxu66/Lab_4/blob/main/picture/bfefda83ccee0b65122eec70388d7b5.png)  
## 试验心得  
本次试验学到了java IO的写入和输出。相比较于其他内容，个人感觉层次上更高级一些，难度也相对大了。这次试验还要考虑java jdk的版本，否则负责写入的代码会出现错误或者写入之后的文本为乱码  
这次试验我用的jdk版本为11。


