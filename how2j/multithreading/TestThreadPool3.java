package multithreading;

public class TestThreadPool3 {
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();                 //线程池构造的时候就会启动消费者线程
        int sleep = 1000;
        while(true){
            pool.add(new Runnable(){                        //实现Runnable接口后 实例化再传给pool.add
                public void run(){
                    System.out.println("执行任务");
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
            try{
                Thread.sleep(sleep);                    //间隔一秒向线程池钟添加任务
                sleep = sleep>100?sleep-100:sleep;      //缩短线程添加时间
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}