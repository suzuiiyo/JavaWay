package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class encodingFile {
    public static void main(String[] args){
        File f1 = new File("d:/Studio/JavaWay/AC/DC/encodingFile.txt");
        try(InputStream in = new FileInputStream(f1)){
            if(!f1.exists()){
                f1.createNewFile();
                char[] ch = new char[];
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}