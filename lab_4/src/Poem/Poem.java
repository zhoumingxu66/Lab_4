package Poem;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Poem {
    // 定义一个poems方法，接收一个String类型的文件名或文件路径，返回一个StringBuilder类型的值，同时捕获IOException
    public static StringBuilder poems(String path) throws IOException {
        // 创建一个String类型的ArrayList数组，用来将诗按格式分好组
        ArrayList<String> strList = new ArrayList<>();
        // content用来保存读取出来的诗
        String content;
        // 用FileReader来操作文件，传入文件路径或文件名，同时制定字符集为UTF-8
        try(Reader reader = new FileReader(path)) {
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
        }
        // str用来保存提取出来的每句诗
        String str;
        // index是作为截取字符串的辅助索引
        int index = 0;
        // 对刚才拼接好的字符串content进行循环遍历
        for (int i = 0; i < content.length(); i++) {
            // 因为每句诗的长度为14个字符，所以让i对14取余，如果等于0，那就表明i之前的字符数够14个
            if (i % 14 == 0) {
                // 进入if语句处理，用substring方法截取字符串，括号里第一个参数是开始截取的索引，第二个是结束的索引
                str = content.substring(index, i);
                // 把截取好的字符串添加到前边定义好的数组中
                strList.add(str);
                // 让index等于i，为的是截取下一段字符串
                index = i;
            }
        }
        // 此时在定义一个StringBuilder类型的变量，对数组中的每一项做进一步处理
        StringBuilder poem = new StringBuilder();
        // 用for循环来遍历数组，做的时候测试了一下，发现索引为0的数组存储的是“[” 所以循环从索引1开始
        for (int i = 1; i < strList.size(); i++) {
            // 字符串s用来保存数组中索引为i的那句诗
            String s = strList.get(i);
            // 然后在对s进行循环，把字符串处理成真正的古诗格式
            for (int j = 0; j < s.length(); j++) {
                if (j == 7) {
                    // 当j等于7的时候对字符串进行处理，处理完类似于这样：汉皇重色思倾国，御宇多年求不得。
                    s = s.substring(0, j) + "，" + s.substring(j, s.length()) + "。";
                }
            }
            // 把每个处理好的字符串进行拼接，并加换行符用来换行，使之成为每14个字符为一行
            poem.append(s + "\n");
        }
        return poem;
    }
}

