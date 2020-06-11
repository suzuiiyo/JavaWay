package multithreading;

import java.io.File;

public class TestThread5 {
    public static void search(File file, String search) {
        if(file.isFile()){
            if(file.getName().toLowerCase().endsWith(".java")){
                //���ҵ�.java�ļ���ʱ��,������һ���߳�,����ר�ŵĲ���
                new SearchFileThread(file, search).start();             //������ѯ����ƥ�����ַ������߳�.start
            }
        }
        if(file.isDirectory()){
            File[] fs = file.listFiles();
            for(File f : fs){               //��Ŀ¼�ݹ����
                search(f, search);
            }
        }
    }

    public static void main(String[] args){
        File folder = new File("e:\\project");
        search(folder, "Magic");
    }
}