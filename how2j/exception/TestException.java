package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestException {
    public static void main(String[] args){
        method1();
    }
    private static void method1(){
        try{
            method2();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void method2() throws FileNotFoundException{
        File f = new File("d:/dota2.exe");
        System.out.println("试图打开d:/dota2.exe");
        new FileInputStream(f);
        System.out.println("成功打开");
    }
}