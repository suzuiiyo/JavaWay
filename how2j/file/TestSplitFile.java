package file;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class TestSplitFile {
    public static void main(String[] args){
        String path1 = "d:";
        String name = "\\Studio\\JavaWay\\AC\\DC\\scared";
        String end = ".gif";
        String path2;

        double l = Math.pow(2, 10)*100;   //文件长度
        //long n=10;   //设置分割总数
        File f = new File(path1 + name + end);    //转换成文件对象
        File f2;
        InputStream in = null;              //申明字节流
        PrintStream out = null;             //申明打印流
        try{
            in = new FileInputStream(f);    //将文件f转换成字节输入流
            int tempbyte;                   //字节流返回值,为-1时字节流结束
            int i = 0;
            for(i=0; i<=(int)(f.length()/l); i++){
                path2 = path1 + name + i + end;
                f2 = new File(path2);
                if(!f2.exists()){
                    f2.createNewFile();
                }
                out = new PrintStream(f2);
                
                while((tempbyte = in.read()) != -1){   //数据的下一个字节，如果达到流的末尾， 则返回-1 
                    out.println((char)tempbyte);   //打印的什么鬼
                    System.out.write(tempbyte);
                    if(f2.length()>l)
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