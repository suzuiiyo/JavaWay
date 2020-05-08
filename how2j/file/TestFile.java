package file;
import java.io.File;

public class TestFile {
    public static void main(String[] args){
        //绝对路径
        File f1 = new File("d?:/Studio/JavaWay/rainyblue.jpg");
        System.out.println("f1的绝对路径: " + f1.getAbsolutePath());
        //相对路径，相对于工作目录
        File f2 = new File("d:/Studio/JavaWay/Puzzle4.java");
        System.out.println("f2的绝对路径：" + f2.getAbsolutePath());

        //把f1作为父目录创建对象
        File f3= new File(f1, "LOL.exe");

        System.out.println("f3的绝对路径： " + f3.getAbsolutePath());
    }
}