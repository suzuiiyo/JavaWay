package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class testCharStream2 {
    public static void main(String[] args){
        //准备文件
        File f = new File("d:/Studio/JavaWay/AC/DC/printStream2.txt");
        try {
            if(!f.exists()){
                f.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try(FileWriter fr = new FileWriter(f)){
            String data = "abcdefg1234567890";
            char[] cd = data.toCharArray();
            fr.write(cd);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}