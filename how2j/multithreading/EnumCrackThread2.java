package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnumCrackThread2 {
    public static void main(String[] args) {
        Random r = new Random();
        String passwd = new String(String.valueOf((char)(r.nextInt(122-48)+48)));       //��������Ϊ3������ַ���
        List<String> passVes = new ArrayList<>();               //����������ֵ���Ե�����
        for(int i=0; i<2; i++){
            passwd += String.valueOf((char)(r.nextInt(122-48)+48));
        }
        System.out.println("������: " + passwd);
        System.out.println("\n ******************\n");

        CrackPasswdThread2 crackPassThread = new CrackPasswdThread2(passwd, passVes);
        crackPassThread.start();
        System.out.println(passVes.size());     //Ϊʲôʼ����0??

        CrackDiaryThread2 crackDiaryThread = new CrackDiaryThread2(passVes);
        crackDiaryThread.start();
    }
}