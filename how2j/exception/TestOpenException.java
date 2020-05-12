package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestOpenException {
    public static void main(String[] args) {
        File f = new File("d:/doat2.exe"); 
        InputStream in = null;
        // 试图打开文件rainyblue.jpg,会抛出FileNotFoundException,如果不处理该异常会导致编译错误
        try{
            System.out.println("试图打开d:/LOL.exe");
            in = new FileInputStream(f);
            System.out.println("成功打开");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse("2016-06-03");
        } 
        /*catch (FileNotFoundException e) {
            System.out.println("d:/data2不存在");
            e.printStackTrace();
        }
        catch(ParseException e){
            System.out.println("日期格式解析不正确");
            e.printStackTrace();
        }*/
        catch(FileNotFoundException | ParseException e){
            if(e instanceof FileNotFoundException){
                System.out.println("找不到文件");
            }
            if(e instanceof ParseException){
                System.out.println("日期格式解析错误");
            }
            e.printStackTrace();
        }
        finally{
            //在finally里关闭流
            if(null != in){
                try{
                    in.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
