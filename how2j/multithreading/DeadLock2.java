package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock2 {
    public static void main(String[] args) throws InterruptedException {
        Lock lock_bh = new ReentrantLock();
        Lock lock_AM = new ReentrantLock();

        Thread t1 = new Thread(){
            public void run(){
                boolean bhLocked = false;
                boolean AMLocked = false;

                try{
                    bhLocked = lock_bh.tryLock(10, TimeUnit.SECONDS);  //tryLock返回值为真表示占有成功
                    if(bhLocked){
                        System.out.println("t1 成功占有赏金猎人");
                        Thread.sleep(1000);
                        System.out.println("t1 试图在10秒内占有敌法");
                        try{
                            AMLocked = lock_AM.tryLock(10, TimeUnit.SECONDS);
                            if(AMLocked){
                                System.out.println("t1 成功占有敌法, 开始战斗");
                            }else{
                                System.out.println("t1 并不能占用敌法，放弃");
                            }
                        }finally{
                            if(AMLocked){
                                System.out.println("t1 释放敌法");
                                lock_bh.unlock();
                            }
                        }
                    }
                }catch(InterruptedException e1){
                    e1.printStackTrace();
                }finally{
                    if(bhLocked){                        //trylock返回值为假表示占有失败,释放
                        System.out.println("t1 释放赏金");
                    }
                }
            }
        };
        t1.start();
        Thread.sleep(1000);    //throws InterruptedException

        Thread t2 = new Thread(){
            public void run(){
                boolean AMLocked = false;
                boolean bhLocked = false;
                try{
                    AMLocked = lock_AM.tryLock(10, TimeUnit.SECONDS);
                    if(AMLocked){
                        System.out.println("t2  已成功占有敌法");
                        //停顿1000秒,另一个线程有足够的时间占有敌法
                        Thread.sleep(1000);
                        System.out.println("t2 试图在10秒内占有赏金猎人");
                        try{
                            bhLocked = lock_bh.tryLock(10, TimeUnit.SECONDS);
                            if(bhLocked){
                                System.out.println("t2 已占有赏金猎人");
                            }else{
                                System.out.println("t2 老是占用不了赏金猎人，放弃");
                            }
                        }
                        finally{
                            if(bhLocked){
                                System.out.println("t2 释放赏金猎人");
                                lock_bh.unlock();
                            }
                        }
                    }
                }catch(InterruptedException e1){
                    e1.printStackTrace();
                }finally{
                    if(AMLocked){
                        System.out.println("t2 释放敌法");
                        lock_AM.unlock();
                    }
                }
            }
        };
        t2.start();
    }
}