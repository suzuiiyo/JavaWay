package file;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestStream {
    public static void main(String[] args){
        try{
            File f = new File("d:/Studio/JavaWay/AC/DC/testStream.txt");
            //准备长度是2的字节数组,用88，89初始化，其对应的字符分别是X,Y

            //首先获取文件所在目录
            File dir = f.getParentFile();
            //如果该目录不存咋,则创建该目录
            if(!dir.exists()){
                //dir.mkdir(); //使用mkdir会抛出异常,因为该目录的父目录也不存在
                dir.mkdirs(); //使用mkdirs则会把不存在的目录都创建好
            }
            byte data[] = new byte[123];
            for(byte i=0; i<120; i++){
                data[i] = i;
            }
            //创建基于文件的输入流
            //FileInputStream fis = new FileInputStream(f);
            //通过这个输入流，就可以把数据从硬盘，读取到JVM中，也就是读取到内存中
            FileOutputStream fos  = new FileOutputStream(f);
            //通过这个输出流，就可以把数据从内存中，读取到硬盘中
            fos.write(data);
            //关闭输出流
            fos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}