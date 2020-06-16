package multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSychronized {
    public static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void main(String[] args) {
        final Object someObject = new Object();             //�ڲ������someObject����,����Ϊfinal
        Thread t1 = new Thread(){
            public void run(){
                try{
                    System.out.println(now() + " t1�߳�������");
                    System.out.println(now() + this.getName() + "��ͼռ�ж���: someObject");
                    synchronized(someObject){
                        System.out.println(now()+this.getName()+ "ռ�ж���someObject");
                        Thread.sleep(5000);
                        System.out.println(now()+this.getName() + "�ͷŶ���: someObject");
                    }
                    System.out.println(now()+" t1�߳̽���");
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t1.setName(" t1");
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                try{
                    System.out.println(now()+" t2�߳��Ѿ�����");
                    System.out.println(now()+ this.getName() + "��ͼռ�ж���: someObject");
                    synchronized(someObject){
                        System.out.println(now()+this.getName() + "ռ�ж��� someObject");
                        Thread.sleep(5000);
                        System.out.println(now()+this.getName()+ "�ͷŶ���someObject");
                    }
                    System.out.println(now() + " t2�߳̽���");
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t2.setName(" t2");
        t2.start();
    }
}