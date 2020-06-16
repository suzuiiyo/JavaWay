package multithreading;

import charactor.Hero;

public class TestSynchronized4 {
    public static void main(String[] args) {
        final Hero beastMaster = new Hero("兽王", 234);
        int n= 10000;

        Thread[] addThreads = new Thread[n];
        Thread[] reducThreads = new Thread[n];

        for(int i=0; i<n; i++){
            Thread t = new Thread(){
                public void run(){
                    beastMaster.recover();
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
                    beastMaster.hurt();
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reducThreads[i] = t;
        }

        for(Thread t : addThreads){
            try{
                t.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        for(Thread t : reducThreads){
            try{
                t.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.printf("%d个增加线程和%d个减少线程结束后%n%s的血量是%.0f%n", n, n, beastMaster.name, beastMaster.hp);
    }
}