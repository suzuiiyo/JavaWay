package multithreading;

import charactor.Hero;

public class TestDeadLock {
    public static void main(String[] args) {
        final Hero lina = new Hero("����", 344);
        final Hero juggnant = new Hero("��ʥ", 455);

        Thread t1 = new Thread(){
            public void run(){
                //ռ������
                synchronized(lina){
                    System.out.println("t1 ��ռ��"+ lina.name);
                    try{
                        //ͣ��1000����,��һ���߳����㹻��ʱ��ռ������
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("t1 ��ͼռ��"+juggnant.name);
                System.out.println("t1 �ȴ���....");
                synchronized(juggnant){
                    System.out.println("do something");
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                //ռ�н�ʥ
                synchronized(juggnant){
                    System.out.println("t2 ��ռ�н�ʥ");
                    try{
                        //ͣ��1000����,��һ���߳����㹻��ʱ��ռ����������
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("t2 ��ͼռ������");
                    System.out.println("t2 �ȴ���....");
                    synchronized(lina){
                        System.out.println("do something");
                    }
                }
            }
        };
        t2.start();
    }
}