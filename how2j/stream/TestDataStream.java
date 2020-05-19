package stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataStream {
    public static void main(String[] args){
        write();
        read();
    }

    private static void write() {
        File f = new File("d:/Studio/JavaWay/AC/DC/DataTraveler.txt");
        try(FileOutputStream fos = new FileOutputStream(f); DataOutputStream dos = new DataOutputStream(fos)){
            dos.writeBoolean(true);
            dos.writeInt(300);
            dos.writeUTF("123 this is gareen");
        }catch(IOException e){
            e.printStackTrace();
        }
	}

	private static void read() {
        File f = new File("d:/Studio/JavaWay/AC/DC/DataTraveler.txt");
        try(FileInputStream fis = new FileInputStream(f); DataInputStream dis = new DataInputStream(fis)){
            if(!f.exists()){
                f.createNewFile();
            }
            boolean b = dis.readBoolean();
            int i = dis.readInt();
            String str = dis.readUTF();

            System.out.println("读取到布尔值：" +b);
            System.out.println("读取到整数：" +i);
            System.out.println("读取到字符串：" +str);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}