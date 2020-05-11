package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.io.PrintStream;

public class TestSplitFile {
    public static void main(String[] args){
        String path1 = "d:";
        String name = "\\Studio\\JavaWay\\AC\\DC\\scared";
        String end = ".gif";
        String path2;

        double size = Math.pow(2, 10)*100;   //文件长度
        //long n=10;   //设置分割总数
        File f = new File(path1 + name + end);    //转换成文件对象
        File f2;
        byte[] byteArr = new byte[(int)f.length()];
        InputStream in = null;              //申明输入流
        FileOutputStream out = null;             //申明输出流
        try{
            in = new FileInputStream(f);    //将文件f转换成字节输入流
            int tempbyte;                   //字节流返回值,为-1时字节流结束
            int i = 0;
            int count =0;
            for(i=0; i<=(int)(f.length()/size); i++){
                path2 = path1 + name + i + end;
                f2 = new File(path2);
                if(!f2.exists()){
                    f2.createNewFile();
                }
                out = new FileOutputStream(f2);
                count = i*(int)size;
                
                while((tempbyte = in.read()) != -1){
                    if(i<18) {  //数据的下一个字节，如果达到流的末尾， 则返回-1 
                        out.write(byteArr, count, (int)size-1);   //从byte数组写入bye到输出流
                        System.out.write(tempbyte);
                    }
                    else if(i==18){
                        out.write(byteArr, count, byteArr.length-count);   //从byte数组写入bye到输出流
                        System.out.write(tempbyte);
                    }
                    if(f2.length()>size)
                        break;                  //子文件到达指定大小就创建下一个文件;
                }
            }
            out.flush();
            out.close();
            in.close();
        }catch (IOException e){
            e.printStackTrace();
            return;
        }
    }
}