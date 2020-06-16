package multithreading;

import charactor.Hero;

public class TestSychronized3 {
    public static void main(String[] args) {
        final Hero beastMaster = new Hero();
        beastMaster.name = "����";
        beastMaster.hp = 10000;

        int n = 10000;
        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];

        for(int i=0; i<n; i++){
            Thread t = new Thread(){
                public void run(){
                    //ʹ��beastMaster��Ϊsynchronized
                    synchronized(beastMaster){
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
            addThreads[i]=t;
        }
        for(int i=0; i<n; i++){
            Thread t = new Thread(){
                public void run(){
                    //beastMaster��Ϊsynchronized
                    //�ڷ���hurt����synchronized(this)
                    beastMaster.hurt();
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

        for(Thread t : addThreads){
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
        System.out.printf("%d�������̺߳�%d�������߳̽�����%n%s��Ѫ����%.0f%n", n, n, beastMaster.name, beastMaster.hp);
    }
}