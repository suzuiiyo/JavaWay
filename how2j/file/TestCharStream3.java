package file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestCharStream3 {
    public static void main(String[] args){
        File f = new File("d:/Studio/JavaWay/AC/DC/printStream3.txt");
        try{
            if(!f.exists()){
                f.createNewFile();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        try(FileReader fr = new FileReader(f)){
            char[] all = new char[(int) f.length()];
            for(char each : all)
                System.out.println(each);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}