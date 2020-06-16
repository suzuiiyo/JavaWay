package multithreading;
import charactor.Hero;

public class TestDeadLock2 {
    public static void main(String[] args) {
        final Hero lina = new Hero("莉娜");
        final Hero juggnant = new Hero("剑圣");
        final Hero earthquake = new Hero("撼地者");

        Thread t1 = new Thread(){
            public void run(){
                synchronized(lina){
                    System.out.println("t1 已占有" + lina.name);
                    try{
                        //停顿1000毫秒,另一个线程有足够的时间占有juggnant
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("t1 试图占有" + juggnant.name);
                    System.out.println("t1 等待中....");
                    synchronized(juggnant){
                        System.out.println("do something");
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                System.out.println("t2 已占有" + juggnant.name);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("t2 试图占有" + earthquake.name);
                System.out.println("t2 等待中....");
                synchronized(earthquake){
                    System.out.println("do something");
                }
            }
        };
        t2.start();

        Thread t3 = new Thread(){
            public void run(){
                System.out.println("t3 已占有" + earthquake.name);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("t3 试图占有%s" + lina.name);
                System.out.println("t3 等待中....");
                synchronized(lina){
                    System.out.println("do something");
                }
            }
        };
        t3.start();
    }
}