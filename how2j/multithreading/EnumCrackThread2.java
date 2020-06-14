package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnumCrackThread2 {
    public static void main(String[] args) {
        Random r = new Random();
        String passwd = new String(String.valueOf((char)(r.nextInt(122-48)+48)));       //创建长度为3的随机字符串
        List<String> passVes = new ArrayList<>();               //创建容器放值尝试的密码
        for(int i=0; i<2; i++){
            passwd += String.valueOf((char)(r.nextInt(122-48)+48));
        }
        System.out.println("密码是: " + passwd);
        System.out.println("\n ******************\n");

        CrackPasswdThread crackPassThread = new CrackPasswdThread(passwd, passVes);
        crackPassThread.start();

        CrackDiaryThread crackDiaryThread = new CrackDiaryThread(passVes);
        crackDiaryThread.start();
    }
}