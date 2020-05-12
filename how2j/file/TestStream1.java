package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class TestStream1 {
    File f = new File("d:/Studio/JavaWay/AC/DC/testStream.txt");

    //把流定义在try()里， try, catch或者finally结束的时候，会自动关闭
    try(FileInputStream fis = new FileInputStream(f)){
        byte[] all = new byte[(int) f.length()];
        fis.read(all);
        for(byte b : all){
            System.out.println(b);
        }
    } catch (IOException e){
        e.printStackTrace();
    }
}