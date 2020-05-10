package file;
import java.io.File;
import java.io.IOException;

public class FindWindows {
    public static void main(String[] args){
        File f = new File("c:/Windows");
        //获取当前目录
        System.out.println("当前文件夹是: " +f);
        //判断是否是文件
        System.out.println("判断是否存在： " + f.exists());
        //判断是否文件夹
        System.out.println("判断是否文件夹： " + f.isDirectory());
        //判断是否文件(非文件夹)
        System.out.println("判断是否文件: " + f.isFile());
        double t1 = System.currentTimeMillis();
        //以文件数组的形式，返回当前文件夹下的所有文件
        File[] fs = f.listFiles();
        for(int i=0; i<fs.length; i++){
            for(int j=0; j<fs.length-i-1; j++){
                if(fs[j].length()>fs[j+1].length()){
                    File temp = fs[j];
                    fs[j] = fs[j+1];
                    fs[j+1] = temp;
                }
            }
        }
        double t2 = System.currentTimeMillis();
        System.out.println(f+"文件夹下，最小的文件是: " + fs[0] +"其大小是"+fs[0].length() + "\n最大的文件是: " + fs[fs.length-1] +"其大小是" +fs[fs.length-1].length());
        System.out.println("总消耗时间为： " + (t2 - t1) + "毫秒");
    }    
}