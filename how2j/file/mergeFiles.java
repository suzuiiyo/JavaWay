package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class mergeFiles {
    public static void main(String[] arg) {
        double size = Math.pow(2, 10)*100;
        String dirHead = "d:/Studio/JavaWay/AC/DC/";
        String name = "scared";
        String dirTail = ".gif";
        //File f = new File(dirHead);
        File f1 = new File(dirHead + name + dirTail);
        byte[] byteArr = new byte[(int)f1.length()];
        //File[] fs = f.listFiles();
        InputStream in = null;
        FileOutputStream fout = null;
        try{
            File f2 = new File(dirHead + "scareME" + dirTail);
            if(!f2.exists()){
                f2.createNewFile();
            }
            fout = new FileOutputStream(f2);        //输出流fout写入文件f2

            for(int i=0; i<=(int)(f1.length()/size); i++){
                //if(fs[i].length() == size){
                File f3 = new File(dirHead + name + i + dirTail);    //为之前分割出来的每一个文件创建对象
                in = new FileInputStream(f3);               //将每一个分割出的文件读入输入流
                byteArr = InputStreamtoByteArray.read(in);          //将输入流里的byte存到byte数组
                fout.write(byteArr);                        //将byte数组的元素写入输出流，从而写入f2文件
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