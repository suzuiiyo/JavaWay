package file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestCharStream {
    public static void main(String[] args){
        //׼���ļ�BitStream��txt���е�������AB
        File f = new File("d:/Studio/JavaWay/AC/DC/charStream.txt");
        //���������ļ���Reader
        try(FileReader fr = new FileReader(f)){
            //�����ַ����飬�䳤�Ⱦ����ļ��ĳ���
            char[] all = new char[(int)f.length()];
            //���ַ�������ʽ��ȡ�ļ���������
            fr.read(all);
            for(char b : all){
                //��ӡ������A B
                System.out.println(b);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}