package file;
import java.io.File;

public class TestFile {
    public static void main(String[] args){
        //����·��
        File f1 = new File("d?:/Studio/JavaWay/rainyblue.jpg");
        System.out.println("f1�ľ���·��: " + f1.getAbsolutePath());
        //���·��������ڹ���Ŀ¼
        File f2 = new File("d:/Studio/JavaWay/Puzzle4.java");
        System.out.println("f2�ľ���·����" + f2.getAbsolutePath());

        //��f1��Ϊ��Ŀ¼��������
        File f3= new File(f1, "LOL.exe");

        System.out.println("f3�ľ���·���� " + f3.getAbsolutePath());
    }
}