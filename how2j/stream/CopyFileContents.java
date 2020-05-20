package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class CopyFileContents {
    public static void main(String[] args){
        File f = new File("d:/Studio/JavaWay/AC/DC/BOM.txt");
        File f1 = new File("d:/Studio/JavaWay/AC/DC/BOM2.txt");
        try(BufferedReader bfr = new BufferedReader(new FileReader(f));
            BufferedWriter bfw = new BufferedWriter(new FileWriter(f1))){
                if(!f1.exists()){
                    f1.createNewFile();
                }
            String str = bfr.readLine();
            bfw.write(str);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}