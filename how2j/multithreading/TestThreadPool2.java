package multithreading;

public class TestThreadPool2 {
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        for(int i=0; i<5; i++){
            Runnable task = new Runnable(){
                public void run(){
                    //System.out.println("ִ������");
                    //��������Ǵ�ӡһ�仰
                    //�����Ƿ����ļ�
                    //������������
                }
            };

            pool.add(task);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}