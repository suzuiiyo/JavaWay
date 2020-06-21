package multithreading;

public class TestThreadPool3 {
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();                 //�̳߳ع����ʱ��ͻ������������߳�
        int sleep = 1000;
        while(true){
            pool.add(new Runnable(){                        //ʵ��Runnable�ӿں� ʵ�����ٴ���pool.add
                public void run(){
                    System.out.println("ִ������");
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
            try{
                Thread.sleep(sleep);                    //���һ�����̳߳����������
                sleep = sleep>100?sleep-100:sleep;      //�����߳����ʱ��
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}