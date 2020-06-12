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
                   final  int j = i;                                                   //�ڲ��ڷ����ⲿ����ֻ����final
                   Thread t1    = new Thread() {                          //�ڲ������ഴ���߳�
                        public void run() {
                            try {
                                String str2 = null;
                                if((str2 = readFileContent(flist[j], "������")) != null)
                                    System.out.println(str2);
                            } catch (UnsupportedEncodingException | FileNotFoundException e) {
                            // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    };
                    t1.start();
                }                           //�����Ŀ¼  ҪӦ�õݹ�,��������εݹ飿 Y�������
        }
    }

    public static String  readFileContent(File f, String str) throws UnsupportedEncodingException, FileNotFoundException {
        try(InputStreamReader fr = new InputStreamReader(new FileInputStream(f), "UTF-8")){
            char[] all = new char[(int) f.length()];  //���ļ�����ȫ��ת�����ַ���������
            fr.read(all);     //���ļ�����ȫ�������ַ�����
            String fileStr = String.valueOf(all);
            if(fileStr.contains(str)){
                return f.getName();
            }
        }catch(IOException e){
            System.out.println(e.toString() + "ת���ַ������󴴽�ʧ��");
        }
        return null;
    }
}