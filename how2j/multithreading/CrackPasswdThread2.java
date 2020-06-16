package multithreading;

import java.util.List;
import java.util.Random;

public class CrackPasswdThread2 extends Thread {
    private String passStr;
    private List<String> passVes;               //此处不能实例化,否则访问不到main里面的list,这个地方是一个声明j
    public CrackPasswdThread2(String passStr, List<String> list){
        this.passStr = passStr;
        this.passVes = list;
    }

    public void run(){
        boolean flag = true;
        while(flag){
            char[] crackCh = new char[3];
            Random r = new Random();

            for(int i=0; i<crackCh.length; i++){
                crackCh[i] = (char)(r.nextInt(122 -48) +48);
            }
            String crackStr = String.valueOf(crackCh);
            passVes.add(crackStr);
            if(crackStr.equals(passStr)){
                System.out.printf("破解成功,密码是%s%n", crackStr);
                flag = false;
            }
        }
    }
}