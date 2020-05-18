package stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class TestBufferedReader {
    public static void main(String[] args) {
        String str1 = "QOP kill WarLock with the ultimate \n\r";
        String str2 = "WarLock revive after 1 minutes \n\r";
        String str3 = "WarLock try to revenge QOP but was killed again\n\r";

        String str = str1 + str2 + str3;
        File f = new File("d:/Studio/JavaWay/AC/DC/revenge.txt");
        try(OutputStream fout = new FileOutputStream(f)){
            if(!f.exists()){
                f.createNewFile();
            }
            byte[] byIn = str.getBytes("UTF-8");
            fout.write(byIn);
        }catch(IOException e){
            e.printStackTrace();
        }

        try(FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)){
            while(true){
                //一次读一行
                String line = br.readLine();
                if(null == line){
                    break;
                }
                System.out.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        File f2 = new File("d:/Studio/JavaWay/AC/DC/revenge2.txt");
        try(FileWriter fw = new FileWriter(f2);             //创建文件字符流
        PrintWriter pw = new PrintWriter(f2)){               //缓存必须建立在一个存在的流的基础上
            pw.println("None konws CoronaVirus than me!");
            pw.println("We have predicted that there would be 22 millions people died, but now we only died 70 thousands people");
            pw.println("literally, that's what I mean we have got a great victoration in the fighting with the VoronaVirus.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}