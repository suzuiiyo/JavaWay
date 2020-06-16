package multithreading;

import charactor.Hero;

public class TestDeadLock {
    public static void main(String[] args) {
        final Hero lina = new Hero("莉娜", 344);
        final Hero juggnant = new Hero("剑圣", 455);

        Thread t1 = new Thread(){
            public void run(){
                //占有莉娜
                synchronized(lina){
                    System.out.println("t1 已占有"+ lina.name);
                    try{
                        //停顿1000毫秒,另一个线程有足够的时间占有莉娜
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("t1 试图占有"+juggnant.name);
                System.out.println("t1 等待中....");
                synchronized(juggnant){
                    System.out.println("do something");
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                //占有剑圣
                synchronized(juggnant){
                    System.out.println("t2 已占有剑圣");
                    try{
                        //停顿1000毫秒,另一个线程有足够的时间占有暂用莉娜
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("t2 试图占有莉娜");
                    System.out.println("t2 等待中....");
                    synchronized(lina){
                        System.out.println("do something");
                    }
                }
            }
        };
        t2.start();
    }
}