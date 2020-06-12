package multithreading;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchFileThread extends Thread {          //创建一个线程专门用来在文件内容找目标子字符串
    private File file;
    private String search;
    public SearchFileThread(File file, String search){
        this.file   = file;
        this.search = search;
    }

    public void run(){
        String fileContent = readFileConent(file);
        if(fileContent.contains(search)){
            System.out.printf("找到了字母表字符串%s，在文件：%s%n", search, file);
        }
    }

    public String readFileConent(File file){
        try(FileReader fr = new FileReader(file)){
            char[] all = new char[(int) file.length()];
            fr.read(all);                       //把文件内容用字符流写到字符数组里
            return new String(all);
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
}