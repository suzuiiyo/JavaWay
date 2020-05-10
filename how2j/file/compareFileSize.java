package file;
import java.io.File;

public class compareFileSize {
    static long minSize = Long.MAX_VALUE;
    static long maxSize = 0;
    static File minFile = null;
    static File maxFile = null;

    //ʹ�õݹ�������һ���ļ��е����ļ�
    public static void listFiles(File file){
        if(file.isFile()){
            if(file.length()>maxSize){
                maxSize = file.length();
                maxFile = file;
            }
            if(file.length()!=0&&file.length()<minSize){
                minSize = file.length();
                minFile = file;
            }
            return;
        }
        if(file.isDirectory()){
            File[] fs = file.listFiles();
            if(null!=fs){
                for(File f : fs){
                    listFiles(f);      //��fs[]���ÿһ���ļ����еݹ�
                }
            }
        }
        //System.out.println(minFile + "     " + maxFile);
    }

    public static void main(String[] args){
        double t1 = System.currentTimeMillis();
        File f = new File("c:/Windows");
        listFiles(f);
        //System.out.printf("�����ļ���s%, ���С��%,d�ֽ�%n", maxFile.getAbsolutePath(), maxFile.length());
        //System.out.printf("��С���ļ���s%, ���С��%,d�ֽ�%n", minFile.getAbsolutePath(), minFile.length());
        System.out.println("�����ļ���: " + maxFile + "��СΪ��" + maxFile.length());
        System.out.println("��С���ļ���: " + minFile + "��СΪ��" + minFile.length());
        double t2 = System.currentTimeMillis();
        System.out.println("�ܹ���ʱ�� " + (t2 - t1) + "����");
    }
}