package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class FileReaderChinese {
    public static void main(String[] args){
        File f = new File("d:/Studio/JavaWay/AC/DC/hanzi.txt");
        System.out.println("Ĭ�ϱ��뷽ʽ: " + Charset.defaultCharset());
        //FileReader�õ������ַ�������һ�����Ѿ����ֽڸ���ĳ�ֱ���ʶ������ַ�
        //��FileReaderʹ�õı��뷽ʽ��Charset.defaultCharset()�ķ���ֵ�� ��������ĵĲ���ϵͳ�� ����GBK
        try(FileReader fr = new FileReader(f)){
            char[] cs = new char[(int) f.length()];
            fr.read(cs);
            System.out.printf("FileReader��ʹ��Ĭ�ϵı��뷽ʽ%s,ʶ��������ַ���: %n", Charset.defaultCharset());
            System.out.println(new String(cs));
        }catch(IOException e){
            e.printStackTrace();
        }
        //FileReader�ǲ����ֶ����ñ��뷽ʽ�ģ�Ϊ��ʹ�������ı��뷽ʽ��ֻ��ʹ��InputStreamReader������
        //����ʹ��new InputStreamReader(new FileInputStream(f), Charset.foName("UTF-8"));��������ʽ
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(f), Charset.forName("UTF-8"))){
            char[] cs = new char[(int) f.length()];
            isr.read(cs);
            System.out.printf("InputStreamReader ָ�����뷽ʽUTF-8��ʶ��������ַ���: %n");
            System.out.println(new String(cs));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}