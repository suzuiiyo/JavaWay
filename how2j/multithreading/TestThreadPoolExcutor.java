package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;

public class TestThreadPoolExcutor {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        threadPool.execute(new Runnable(){
            public void run(){
                System.out.println("хннЯ1");
            }
        });
    }
}