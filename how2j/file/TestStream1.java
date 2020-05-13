package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class TestStream1 {
    public static void main(String[] args){
        File f = new File("d:/Studio/JavaWay/AC/DC/testStream.txt");

        //����������try()� try, catch����finally������ʱ�򣬻��Զ��ر�
        try(FileInputStream fis = new FileInputStream(f)){
            byte[] all = new byte[(int)f.length()];
            fis.read(all);
            for(byte b : all){
                System.out.println(b);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}