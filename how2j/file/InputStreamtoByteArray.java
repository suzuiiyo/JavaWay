package file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class InputStreamtoByteArray {
    public static void main(String[] args) {
        File f = new File("d:/Studio/JavaWay/AC/DC/printStream.txt");
        byte[] byteArr = new byte[1024];
        try {
            InputStream in = new FileInputStream(f);
            byteArr = InputStreamtoByteArray.read(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(byte each : byteArr){
            System.out.println(each);
        }
        System.out.println("�����ݸ���Ϊ: " + byteArr.length);
    }
    public static byte[] read(InputStream in) throws IOException{
        try{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();   //�½����������
            byte[] buffer = new byte[1024];     //�½�byte����
			int num = in.read(buffer);          //��������������ֵnum
            while(num != -1){                           
                baos.write(buffer, 0, num);         //��buffer�������byteд�����������
                num = in.read(buffer);
            }
            baos.flush();
            return baos.toByteArray();              //NyteArrayOutputStream��toByteArray����,����ֵ��һ��byte����
        }finally {
            if(in != null){
                in.close();
            }
        }
    }
}