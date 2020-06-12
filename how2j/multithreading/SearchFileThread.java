package multithreading;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchFileThread extends Thread {          //����һ���߳�ר���������ļ�������Ŀ�����ַ���
    private File file;
    private String search;
    public SearchFileThread(File file, String search){
        this.file   = file;
        this.search = search;
    }

    public void run(){
        String fileContent = readFileConent(file);
        if(fileContent.contains(search)){
            System.out.printf("�ҵ�����ĸ���ַ���%s�����ļ���%s%n", search, file);
        }
    }

    public String readFileConent(File file){
        try(FileReader fr = new FileReader(file)){
            char[] all = new char[(int) file.length()];
            fr.read(all);                       //���ļ��������ַ���д���ַ�������
            return new String(all);
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
}