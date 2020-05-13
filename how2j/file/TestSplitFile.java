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

        double size = Math.pow(2, 10)*100;   //文件长度100K
        //long n=10;   //设置分割总数
        File f = new File(path1 + name + end);    //转换成文件对象
        File f2;
        byte[] byteArr = new byte[(int)f.length()];
        FileOutputStream out = null;             //申明输出流
        try(InputStream in = new FileInputStream(f)){
            byteArr = InputStreamtoByteArray.read(in);
            int i = 0;
            int len =0;
            for(i=0; i<=(int)(f.length()/size); i++){
                path2 = path1 + name + i + end;
                f2 = new File(path2);
                if(!f2.exists()){
                    f2.createNewFile();
                }
                out = new FileOutputStream(f2);
                len = i*(int)size;              //记录每byteArr写入f2后的byte的位置
                
                if(i<(int)(f.length()/size)) {  //数据的下一个字节，如果达到流的末尾， 则返回-1 
                    out.write(byteArr, len, (int)size);   //从byte数组写入bye到输出流
                    //System.out.println("非尾巴：" + len);
                }
                else if(i==(int)(f.length()/size)){
                    out.write(byteArr, len, byteArr.length-len);   //从byte数组写入bye到输出流
                    //System.out.println("尾巴：" + (byteArr.length-len));
                }
                if(f2.length()>size)
                    break;                  //子文件到达指定大小就创建下一个文件;
            }
            out.close();
        }catch (IOException e){
            e.printStackTrace();
            return;
        }
    }
}
