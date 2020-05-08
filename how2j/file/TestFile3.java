package file;

import java.io.File;
import java.io.IOException;

public class TestFile3 {
    public static void main(String[] args) throws IOException {
        File f = new File("d:/Studio/JavaWay/file/BENI.jpg");
        //���ַ����������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ����ļ��У�
        f.list();
        //���ļ��������ʽ�����ص�ǰ�ļ����µ������ļ�
        File[] fs= f.listFiles();
        //���ַ�����ʽ���ػ�ȡ�����ļ���
        f.getParent();
        //���ļ���ʽ���ػ�ȡ�����ļ���
        f.getParentFile();
        //�����ļ��У�������ļ���file������,��������Ч
        f.mkdir();
        //�����ļ��У�������ļ���file�����ڣ��ͻ��׳��쳣
        f.mkdirs();
        //����һ�����ļ���������ļ���file�ڣ��ͻ��׳��쳣
        f.createNewFile();
        //���Դ���һ�����ļ�֮ǰ��ͨ�����ᴴ����Ŀ¼
        f.getParentFile().mkdirs();

        //�г����е��̷�c: d: e: �ȵ�
        File.listRoots();

        //ɾ���ļ�
        f.delete();

        //JVM������ʱ��ɾ���ļ��� ��������ʱ�ļ���ɾ��
        f.deleteOnExit();
    }
}