package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class TestBufferData {
    public static void main(String[] args){
        File f = new File("d:/Studio/JavaWay/AC/DC/TwoNum.txt");
        try(FileWriter fw = new FileWriter(f); BufferedWriter bufw = new BufferedWriter(fw)){  //buffered流要建立在字符流的基础上
            if(!f.exists()){
                f.createNewFile();
            }
            String str = "15@16";
            bufw.write(str);
            bufw.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
        try(FileReader fr = new FileReader(f); BufferedReader bufr = new BufferedReader(fr)){
            bufr.read();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}