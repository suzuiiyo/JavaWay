package multithreading;
import charactor.Hero;

public class TestDeadLock2 {
    public static void main(String[] args) {
        final Hero lina = new Hero("����");
        final Hero juggnant = new Hero("��ʥ");
        final Hero earthquake = new Hero("������");

        Thread t1 = new Thread(){
            public void run(){
                synchronized(lina){
                    System.out.println("t1 ��ռ��" + lina.name);
                    try{
                        //ͣ��1000����,��һ���߳����㹻��ʱ��ռ��juggnant
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("t1 ��ͼռ��" + juggnant.name);
                    System.out.println("t1 �ȴ���....");
                    synchronized(juggnant){
                        System.out.println("do something");
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                System.out.println("t2 ��ռ��" + juggnant.name);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("t2 ��ͼռ��" + earthquake.name);
                System.out.println("t2 �ȴ���....");
                synchronized(earthquake){
                    System.out.println("do something");
                }
            }
        };
        t2.start();

        Thread t3 = new Thread(){
            public void run(){
                System.out.println("t3 ��ռ��" + earthquake.name);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("t3 ��ͼռ��%s" + lina.name);
                System.out.println("t3 �ȴ���....");
                synchronized(lina){
                    System.out.println("do something");
                }
            }
        };
        t3.start();
    }
}