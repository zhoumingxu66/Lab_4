package Poem;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Poem {
    // ����һ��poems����������һ��String���͵��ļ������ļ�·��������һ��StringBuilder���͵�ֵ��ͬʱ����IOException
    public static StringBuilder poems(String path) throws IOException {
        // ����һ��String���͵�ArrayList���飬������ʫ����ʽ�ֺ���
        ArrayList<String> strList = new ArrayList<>();
        // content���������ȡ������ʫ
        String content;
        // ��FileReader�������ļ��������ļ�·�����ļ�����ͬʱ�ƶ��ַ���ΪUTF-8
        try(Reader reader = new FileReader(path)) {
            int n;
            // �����������char���͵��ַ������ж���һ��StringBuilder���͵ı�����ƴ��ÿ���ַ���ʹ֮��Ϊ�������ַ���
            StringBuilder sb = new StringBuilder();
            // ����ֽڶ�ȡ�����ĵ�������ʱ��read()��������-1��ѭ������
            while ((n = reader.read()) != -1) {
                // ��append������ƴ��ÿ���ַ�
                sb.append((char) n);
            }
            // ��ƴ�Ӻõ��ַ���ת��ΪString���Ͳ���ֵ��content
            content = sb.toString();
        }
        // str����������ȡ������ÿ��ʫ
        String str;
        // index����Ϊ��ȡ�ַ����ĸ�������
        int index = 0;
        // �Ըղ�ƴ�Ӻõ��ַ���content����ѭ������
        for (int i = 0; i < content.length(); i++) {
            // ��Ϊÿ��ʫ�ĳ���Ϊ14���ַ���������i��14ȡ�࣬�������0���Ǿͱ���i֮ǰ���ַ�����14��
            if (i % 14 == 0) {
                // ����if��䴦����substring������ȡ�ַ������������һ�������ǿ�ʼ��ȡ���������ڶ����ǽ���������
                str = content.substring(index, i);
                // �ѽ�ȡ�õ��ַ�����ӵ�ǰ�߶���õ�������
                strList.add(str);
                // ��index����i��Ϊ���ǽ�ȡ��һ���ַ���
                index = i;
            }
        }
        // ��ʱ�ڶ���һ��StringBuilder���͵ı������������е�ÿһ������һ������
        StringBuilder poem = new StringBuilder();
        // ��forѭ�����������飬����ʱ�������һ�£���������Ϊ0������洢���ǡ�[�� ����ѭ��������1��ʼ
        for (int i = 1; i < strList.size(); i++) {
            // �ַ���s������������������Ϊi���Ǿ�ʫ
            String s = strList.get(i);
            // Ȼ���ڶ�s����ѭ�������ַ�������������Ĺ�ʫ��ʽ
            for (int j = 0; j < s.length(); j++) {
                if (j == 7) {
                    // ��j����7��ʱ����ַ������д���������������������������ɫ˼�������������󲻵á�
                    s = s.substring(0, j) + "��" + s.substring(j, s.length()) + "��";
                }
            }
            // ��ÿ������õ��ַ�������ƴ�ӣ����ӻ��з��������У�ʹ֮��Ϊÿ14���ַ�Ϊһ��
            poem.append(s + "\n");
        }
        return poem;
    }
}

