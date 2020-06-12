package multithreading;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class TestFindContent {
    public static void main(String[] args) {
        String dir = "d:/Studio/JavaWay/AC/DC/";
        File f = new File(dir);
        File[] flist = f.listFiles();
        for (int i = 0; i < flist.length; i++) {
            //System.out.println(flist[i]);
                if (String.valueOf(flist[i]).endsWith(".txt")) {
                   final  int j = i;                                                   //内部内访问外部变量只能是final
                   Thread t1    = new Thread() {                          //内部匿名类创建线程
                        public void run() {
                            try {
                                String str2 = null;
                                if((str2 = readFileContent(flist[j], "就撒娇")) != null)
                                    System.out.println(str2);
                            } catch (UnsupportedEncodingException | FileNotFoundException e) {
                            // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    };
                    t1.start();
                }                           //如果是目录  要应用递归,匿名类如何递归？ Y组合算子
        }
    }

    public static String  readFileContent(File f, String str) throws UnsupportedEncodingException, FileNotFoundException {
        try(InputStreamReader fr = new InputStreamReader(new FileInputStream(f), "UTF-8")){
            char[] all = new char[(int) f.length()];  //将文件内容全部转换城字符存入数组
            fr.read(all);     //把文件内容全部读入字符数组
            String fileStr = String.valueOf(all);
            if(fileStr.contains(str)){
                return f.getName();
            }
        }catch(IOException e){
            System.out.println(e.toString() + "转换字符流对象创建失败");
        }
        return null;
    }
}