package stream;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class TestBufferData2 {
    public static void main(String[] args) {
        File f = new File("d:/Studio/JavaWay/AC/DC/TwoNum.txt");
        try(FileReader fw = new FileReader(f); BufferedReader bufr = new BufferedReader(fw)){            
            String str = null;
            str = bufr.readLine();
            System.out.println(str);
        }catch(IOException e){
            e.printStackTrace();
        }

        try(FileOutputStream fou = new FileOutputStream(f); DataOutputStream fdo = new DataOutputStream(fou);       //DataStream要建立在文件流的基础上
        FileInputStream fin = new FileInputStream(f); DataInputStream fdi = new DataInputStream(fin))           
        {
            fdo.writeInt(77);
            fdo.writeInt(999);
            //fdo.writeBytes("Make America Grip Again!");
            int num1 = fdi.readInt();
            int num2 = fdi.readInt();

            System.out.println("读取到整数1: " + num1);
            System.out.println("读取到整数2: " + num2);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}