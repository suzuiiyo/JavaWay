package file;
import java.io.File;
import java.util.Date;

public class TestFile2 {
    public static void main(String[] args){
        System.out.println("Pay attention! There should be really a file named RainyBlue.jpg then you can see the related information just like file length, the last modified time and so on.");
        File f = new File("d:/Studio/JavaWay/RainyBlue.jpg");
        System.out.println("当前文件是: " +f);
        //文件是否存在
        System.out.println("判断是否存在： " +f.exists());
        //判断是否是文件夹
        System.out.println("判断是否是文件夹: " +f.isDirectory());
        //是否是文件(非文件夹)
        System.out.println("判断是否是文件：" +f.isFile());
        //文件长度
        System.out.println("获取文件的长度: " +f.length());
        //文件最后的修改时间
        long time = f.lastModified();
        Date d = new Date(time);
        System.out.println("获取文件的最后的修改时间: " + d);
        //设置文件修改时间为1970.1.1 08：00：00
        f.setLastModified(0);
        
        //文件重命名
        File f2 = new File("d:/Studio/JavaWay/Community.jpg");
        f.renameTo(f2);
        System.out.println("把RainyBlue.jpg改名成Community.jpg");
    }
}