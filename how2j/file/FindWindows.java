package file;
import java.io.File;
import java.io.IOException;

public class FindWindows {
    public static void main(String[] args){
        File f = new File("c:/Windows");
        //��ȡ��ǰĿ¼
        System.out.println("��ǰ�ļ�����: " +f);
        //�ж��Ƿ����ļ�
        System.out.println("�ж��Ƿ���ڣ� " + f.exists());
        //�ж��Ƿ��ļ���
        System.out.println("�ж��Ƿ��ļ��У� " + f.isDirectory());
        //�ж��Ƿ��ļ�(���ļ���)
        System.out.println("�ж��Ƿ��ļ�: " + f.isFile());
        double t1 = System.currentTimeMillis();
        //���ļ��������ʽ�����ص�ǰ�ļ����µ������ļ�
        File[] fs = f.listFiles();
        for(int i=0; i<fs.length; i++){
            for(int j=0; j<fs.length-i-1; j++){
                if(fs[j].length()>fs[j+1].length()){
                    File temp = fs[j];
                    fs[j] = fs[j+1];
                    fs[j+1] = temp;
                }
            }
        }
        double t2 = System.currentTimeMillis();
        System.out.println(f+"�ļ����£���С���ļ���: " + fs[0] +"���С��"+fs[0].length() + "\n�����ļ���: " + fs[fs.length-1] +"���С��" +fs[fs.length-1].length());
        System.out.println("������ʱ��Ϊ�� " + (t2 - t1) + "����");
    }    
}