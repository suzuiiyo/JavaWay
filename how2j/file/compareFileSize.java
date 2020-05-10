package file;
import java.io.File;

public class compareFileSize {
    static long minSize = Long.MAX_VALUE;
    static long maxSize = 0;
    static File minFile = null;
    static File maxFile = null;

    //使用递归来遍历一个文件夹的子文件
    public static void listFiles(File file){
        if(file.isFile()){
            if(file.length()>maxSize){
                maxSize = file.length();
                maxFile = file;
            }
            if(file.length()!=0&&file.length()<minSize){
                minSize = file.length();
                minFile = file;
            }
            return;
        }
        if(file.isDirectory()){
            File[] fs = file.listFiles();
            if(null!=fs){
                for(File f : fs){
                    listFiles(f);      //对fs[]里的每一个文件进行递归
                }
            }
        }
        //System.out.println(minFile + "     " + maxFile);
    }

    public static void main(String[] args){
        double t1 = System.currentTimeMillis();
        File f = new File("c:/Windows");
        listFiles(f);
        //System.out.printf("最大的文件是s%, 其大小是%,d字节%n", maxFile.getAbsolutePath(), maxFile.length());
        //System.out.printf("最小的文件是s%, 其大小是%,d字节%n", minFile.getAbsolutePath(), minFile.length());
        System.out.println("最大的文件是: " + maxFile + "大小为：" + maxFile.length());
        System.out.println("最小的文件是: " + minFile + "大小为：" + minFile.length());
        double t2 = System.currentTimeMillis();
        System.out.println("总共耗时： " + (t2 - t1) + "毫秒");
    }
}