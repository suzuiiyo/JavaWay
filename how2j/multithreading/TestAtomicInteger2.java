package multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class TestAtomicInteger2 {
    static int value1 = 0;
    static int value3 = 0;
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        AtomicInteger value2 = new AtomicInteger();
        for(int i=0; i<10000; i++){
            Thread t1 = new Thread(){
                public void run(){
                    value1++;
                    value2.incrementAndGet();

                    lock.lock();
                    value3++;
                    lock.unlock();          //如果不解锁,value3的值只会在第一个线程里面自增1
                }
            };
            t1.start();
        }
        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
    }
}   