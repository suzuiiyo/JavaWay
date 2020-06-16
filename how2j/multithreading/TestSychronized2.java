package multithreading;

import charactor.Hero;

public class TestSychronized2 {
    public static void main(String[] args) {
        final Object someObject = new Object();
        final Hero beastMaster = new Hero("兽王", 345);

        int n = 10000;
        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];

        for(int i=0; i<n; i++){
            Thread t = new Thread(){
                public void run(){
                    //任何线程要修改hp的值,必须先占用someObject
                    synchronized(someObject){
                        beastMaster.recover();
                    }
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;
        }

        for(int i=0; i<n; i++){
            Thread t = new Thread(){
                public void run(){
                //任何线程要修改hp的值，必须先占用someObject
                    synchronized(someObject){
                        beastMaster.hurt();
                    
                    }
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    
                }
            };
            t.start();
            reduceThreads[i] = t;
        }
        for(Thread t : reduceThreads){
            try{
                t.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        for(Thread t : reduceThreads){
            try{
                t.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.printf("%d个增加线程和%d个减少线程结束后%n%s的血量是%.0f%n", n, n, beastMaster.name, beastMaster.hp);
    }
}