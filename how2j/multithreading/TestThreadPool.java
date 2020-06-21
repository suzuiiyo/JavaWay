package multithreading;

public class TestThreadPool {
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        int sleep = 1000;
        while(true){
            pool.add(new Runnable(){
                public void run(){
                        //System.out.println("ִ������");
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
            try{
                Thread.sleep(sleep);
                sleep = sleep>100?sleep-100:sleep;
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
