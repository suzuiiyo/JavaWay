package multithreading;

public class TestThreadDaemon {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                int seconds = 0;

                while(true){
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.printf("已经进行了%d秒%n", seconds++);
                }
            }
        };
        t1.setDaemon(true);
        t1.start();
    }
}