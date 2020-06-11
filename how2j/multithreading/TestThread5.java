package multithreading;

import java.io.File;

public class TestThread5 {
    public static void search(File file, String search) {
        if(file.isFile()){
            if(file.getName().toLowerCase().endsWith(".java")){
                //当找到.java文件的时候,就启动一个线程,进行专门的查找
                new SearchFileThread(file, search).start();             //启动查询内容匹配子字符串的线程.start
            }
        }
        if(file.isDirectory()){
            File[] fs = file.listFiles();
            for(File f : fs){               //对目录递归查找
                search(f, search);
            }
        }
    }

    public static void main(String[] args){
        File folder = new File("e:\\project");
        search(folder, "Magic");
    }
}