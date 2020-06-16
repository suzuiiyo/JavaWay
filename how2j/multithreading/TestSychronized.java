package multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSychronized {
    public static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void main(String[] args) {
        final Object someObject = new Object();             //内部类调用someObject变量,定义为final
        Thread t1 = new Thread(){
            public void run(){
                try{
                    System.out.println(now() + " t1线程已运行");
                    System.out.println(now() + this.getName() + "试图占有对象: someObject");
                    synchronized(someObject){
                        System.out.println(now()+this.getName()+ "占有对象：someObject");
                        Thread.sleep(5000);
                        System.out.println(now()+this.getName() + "释放对象: someObject");
                    }
                    System.out.println(now()+" t1线程结束");
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
                    System.out.println(now()+" t2线程已经运行");
                    System.out.println(now()+ this.getName() + "试图占有对象: someObject");
                    synchronized(someObject){
                        System.out.println(now()+this.getName() + "占有对象： someObject");
                        Thread.sleep(5000);
                        System.out.println(now()+this.getName()+ "释放对象：someObject");
                    }
                    System.out.println(now() + " t2线程结束");
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t2.setName(" t2");
        t2.start();
    }
}