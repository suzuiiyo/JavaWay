package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args){
        CopyFile ff = new CopyFile(); 
        String str1 = "d:/Studio/JavaWay/AC/DC/";
        File fdir = new File(str1);
        String[] strf = fdir.list();
        int len = strf.length;
        System.out.println("开始创建副本,请按指示操作");
        ff.copyFile(str1);
        String[] strf2 = fdir.list();
        int len2 = strf2.length;
        if(len2 - len == 1){
            System.out.println("副本创建成功!");
        }
    }

    public void copyFile(String str1){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入被复制的文件名字: ");
        String str2 = s.nextLine();
        s.close();
        File f = new File(str1 + str2);
        String str3 = str1 + "副本" + str2;
        File f1 = new File(str3);
        try(BufferedReader bfr = new BufferedReader(new FileReader(f));
            BufferedWriter bfw = new BufferedWriter(new FileWriter(f1))){
            if(!f1.exists()){
                f1.createNewFile();
            }
            while(true){
                String line = bfr.readLine();
                if(null != line){
                    if(line.equals("")){                //监测到空白行
                        bfw.write("\n\n");
                    }else{
                        bfw.write(line);
                        bfw.flush();
                    }
                }else if(null == line){
                    break;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}