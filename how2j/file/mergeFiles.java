package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class mergeFiles {
    public static void main(String[] arg) {
        double size = Math.pow(2, 10)*100;
        String dirHead = "d:/Studio/JavaWay/AC/DC/";
        String name = "scared";
        String dirTail = ".gif";
        //File f = new File(dirHead);
        File f1 = new File(dirHead + name + dirTail);
        //File[] fs = f.listFiles();
        InputStream in = null;
        PrintStream fout = null;
        try{
            int tempbyte;
            File f2 = new File(dirHead + "scareME" + dirTail);
            if(!f2.exists()){
                f2.createNewFile();
            }
            fout = new PrintStream(f2);
            for(int i=0; i<(int)f1.length()/size; i++){
                //if(fs[i].length() == size){
                File f3 = new File(dirHead + name + i + dirTail);
                in = new FileInputStream(f3);
                
                while((tempbyte = in.read()) != -1){
                    fout.println((char)tempbyte);   //读取in里的byte到输出流
                    System.out.write(tempbyte);
                }
            }
            fout.flush();
            fout.close();
            in.close();
        }catch(IOException e){
            e.printStackTrace();
            return;
        }
    }
}