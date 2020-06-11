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
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < flist.length; i++) {
                    if (String.valueOf(flist[i]).substring(flist.length - 5, flist.length).equals(".java")) {
                        try {
                            String str2 = readFileContent(flist[i], "a");
                            System.out.println(str2);
                        } catch (UnsupportedEncodingException | FileNotFoundException e) {
                        // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
    }

    public static String  readFileContent(File f, String str) throws UnsupportedEncodingException, FileNotFoundException {
        try(InputStreamReader fr = new InputStreamReader(new FileInputStream(f), "UTF-8")){
            char[] all = new char[(int) f.length()];    //���ļ�����ȫ��ת�����ַ���������
            fr.read(all);     //���ļ�����ȫ�������ַ�����
            String fileStr = String.valueOf(all);
            if(fileStr.contains(str)){
                return fileStr;
            }
        }catch(IOException e){
            System.out.println(e.toString() + "ת���ַ������󴴽�ʧ��");
        }
        return null;
    }
}