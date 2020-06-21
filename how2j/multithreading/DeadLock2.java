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
                    bhLocked = lock_bh.tryLock(10, TimeUnit.SECONDS);  //tryLock����ֵΪ���ʾռ�гɹ�
                    if(bhLocked){
                        System.out.println("t1 �ɹ�ռ���ͽ�����");
                        Thread.sleep(1000);
                        System.out.println("t1 ��ͼ��10����ռ�ез�");
                        try{
                            AMLocked = lock_AM.tryLock(10, TimeUnit.SECONDS);
                            if(AMLocked){
                                System.out.println("t1 �ɹ�ռ�ез�, ��ʼս��");
                            }else{
                                System.out.println("t1 ������ռ�õз�������");
                            }
                        }finally{
                            if(AMLocked){
                                System.out.println("t1 �ͷŵз�");
                                lock_bh.unlock();
                            }
                        }
                    }
                }catch(InterruptedException e1){
                    e1.printStackTrace();
                }finally{
                    if(bhLocked){                        //trylock����ֵΪ�ٱ�ʾռ��ʧ��,�ͷ�
                        System.out.println("t1 �ͷ��ͽ�");
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
                        System.out.println("t2  �ѳɹ�ռ�ез�");
                        //ͣ��1000��,��һ���߳����㹻��ʱ��ռ�ез�
                        Thread.sleep(1000);
                        System.out.println("t2 ��ͼ��10����ռ���ͽ�����");
                        try{
                            bhLocked = lock_bh.tryLock(10, TimeUnit.SECONDS);
                            if(bhLocked){
                                System.out.println("t2 ��ռ���ͽ�����");
                            }else{
                                System.out.println("t2 ����ռ�ò����ͽ����ˣ�����");
                            }
                        }
                        finally{
                            if(bhLocked){
                                System.out.println("t2 �ͷ��ͽ�����");
                                lock_bh.unlock();
                            }
                        }
                    }
                }catch(InterruptedException e1){
                    e1.printStackTrace();
                }finally{
                    if(AMLocked){
                        System.out.println("t2 �ͷŵз�");
                        lock_AM.unlock();
                    }
                }
            }
        };
        t2.start();
    }
}