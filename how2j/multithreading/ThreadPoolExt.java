package multithreading;

import java.util.LinkedList;

public class ThreadPoolExt {
    int threadPoolSize;
    LinkedList<Runnable> tasks = new LinkedList<>();
    
    public ThreadPoolExt(){                //���캯��
        int threadPoolSize = 10;            //��ʼ���̳߳ش�С
        synchronized(tasks){                    //ͬ����������
            for(int i=0; i<threadPoolSize; i++){
                new TaskConsumeThread("�����������߳�: " + i).start();          //���������������߳�
            }
        }
    }

    public void add(Runnable r){
        synchronized(tasks){
            tasks.add(r);
            tasks.notify();
        }
    }

    class TaskConsumeThread extends Thread{             //�ڲ���,   �������߳�
        public TaskConsumeThread(String name){
            super(name);
        }
        Runnable task;
        public void run(){
            System.out.println("������" + this.getName());
            while(true){
                synchronized(tasks){
                    while(tasks.isEmpty()){
                        try{
                            tasks.wait();
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeLast();
                    tasks.notifyAll();
                }
                System.out.println(this.getName() + "��ȡ�����񣬲�ִ��");
                task.run();
            }
        }
    }
}