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
        System.out.println("流数据个数为: " + byteArr.length);
    }
    public static byte[] read(InputStream in) throws IOException{
        try{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();   //新建输出流对象
            byte[] buffer = new byte[1024];     //新建byte数组
			int num = in.read(buffer);          //声明输入流返回值num
            while(num != -1){                           
                baos.write(buffer, 0, num);         //将buffer数组里的byte写入输出流对象
                num = in.read(buffer);
            }
            baos.flush();
            return baos.toByteArray();              //NyteArrayOutputStream有toByteArray方法,返回值是一个byte数组
        }finally {
            if(in != null){
                in.close();
            }
        }
    }
}