package file;
import java.io.File;
import java.util.Date;

public class TestFile2 {
    public static void main(String[] args){
        System.out.println("Pay attention! There should be really a file named RainyBlue.jpg then you can see the related information just like file length, the last modified time and so on.");
        File f = new File("d:/Studio/JavaWay/RainyBlue.jpg");
        System.out.println("��ǰ�ļ���: " +f);
        //�ļ��Ƿ����
        System.out.println("�ж��Ƿ���ڣ� " +f.exists());
        //�ж��Ƿ����ļ���
        System.out.println("�ж��Ƿ����ļ���: " +f.isDirectory());
        //�Ƿ����ļ�(���ļ���)
        System.out.println("�ж��Ƿ����ļ���" +f.isFile());
        //�ļ�����
        System.out.println("��ȡ�ļ��ĳ���: " +f.length());
        //�ļ������޸�ʱ��
        long time = f.lastModified();
        Date d = new Date(time);
        System.out.println("��ȡ�ļ��������޸�ʱ��: " + d);
        //�����ļ��޸�ʱ��Ϊ1970.1.1 08��00��00
        f.setLastModified(0);
        
        //�ļ�������
        File f2 = new File("d:/Studio/JavaWay/Community.jpg");
        f.renameTo(f2);
        System.out.println("��RainyBlue.jpg������Community.jpg");
    }
}