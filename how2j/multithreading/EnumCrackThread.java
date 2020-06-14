package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class EnumCrackThread {
    public static void main(String[] args) {
        Random r = new Random();
        List<String> passList = new ArrayList<>();
        StringBuffer passwd = new StringBuffer(String.valueOf((char)(r.nextInt(122-48)+48)));       //创建长度为3的随机字符串
        for(int i=0; i<2; i++){
            passwd.append(String.valueOf((char)(r.nextInt(122-48)+48)));
        }
        System.out.println("密码是: " + passwd);
        System.out.println("\n ****************** \n");

        Thread crackThread = new Thread(){
            public void run(){
                String passwd2 = new String(passwd);            //passwd定义为String  这个地方无法被final修饰
                char[] ch = new char[3];
                boolean flag = true;
                while(flag){
                    for(int i=0; i<ch.length; i++){
                        ch[i] = (char)(r.nextInt(122-48)+48);
                    }
                    String passStr = String.valueOf(ch);
                    passList.add(passStr);
                    if(passStr.equals(passwd2)) {
                        System.out.println("密码是" + passStr + ",破解成功!");
                        flag = false;                           //控制while循环
                    }
                }
            }
        };
        crackThread.start();
        System.out.println("\n ************************\n");
        System.out.println("共尝试:" + passList.size() + "次");     //显示passList.size()的值为0,匿名类引用的外部变量无法传回给外部类

        /*Thread diaryThread = new Thread(){
            public void run(){
                if(!passList.isEmpty()){
                    for(int i=0; i<passList.size(); i++){                 //因为被设为守护线程了,来不及打印完整个进程就结束了
                        System.out.println(passList.get(i));
                    }
                    System.out.println("共尝试:" + passList.size() + "次" + ",密码是：" + passList.get(passList.size()));
                }else{
                    try{
                        Thread.sleep(5000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        diaryThread.setDaemon(true);
        diaryThread.start();*/
    }
}