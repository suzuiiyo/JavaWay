package multithreading;

import java.util.LinkedList;

public class ThreadPoolExt {
    int threadPoolSize;
    LinkedList<Runnable> tasks = new LinkedList<>();
    
    public ThreadPoolExt(){                //构造函数
        int threadPoolSize = 10;            //初始化线程池大小
        synchronized(tasks){                    //同步任务容器
            for(int i=0; i<threadPoolSize; i++){
                new TaskConsumeThread("任务消费者线程: " + i).start();          //启动任务贤妃这线程
            }
        }
    }

    public void add(Runnable r){
        synchronized(tasks){
            tasks.add(r);
            tasks.notify();
        }
    }

    class TaskConsumeThread extends Thread{             //内部类,   消费者线程
        public TaskConsumeThread(String name){
            super(name);
        }
        Runnable task;
        public void run(){
            System.out.println("启动：" + this.getName());
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
                System.out.println(this.getName() + "获取到任务，并执行");
                task.run();
            }
        }
    }
}