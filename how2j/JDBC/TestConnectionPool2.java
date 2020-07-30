package jdbc;

import java.util.ArrayList;
import java.util.List;

public class TestConnectionPool2 {
    private static int threadNumber = 100;
    public static int insertTime = 1;

    public static void main(String[] args) {
        traditionalWay();
        connectionPoolWay();
    }

    private static void connectionPoolWay(){
        ConnectionPool cp =  new ConnectionPool(10);
        System.out.println("��ʼ�����̳߳ط�ʽ�������ݲ���: ");
        long start = System.currentTimeMillis();
        List<Thread> ts = new ArrayList<>();
        for(int i=0; i<threadNumber; i++){
            Thread t = new ConnectionpoolWorkingThread(cp);
            t.start();
            ts.add(t);
        }
        //�ȴ������߳̽���    ���������������������
        for(Thread t : ts){
            try{
                t.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("ʹ�����ӳط�ʽ,����%d���߳�, һ����ʱ%d����%n", threadNumber, insertTime, end-start);
    }

    private static void traditionalWay(){
        System.out.println("��ʼ��ͳ��ʽ�������ݲ���:");
        long start = System.currentTimeMillis();
        List<Thread> ts = new ArrayList<>();
        for(int i=0; i<threadNumber; i++){
            Thread t = new TraditionalWorkingThread();
            t.start();
            ts.add(t);
        }
        //�ȴ������߳̽���
        for(Thread t : ts){
            try{
                t.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("ʹ�ô�ͳ��ʽ������%d���߳�,ÿ���̲߳���%d�����ݣ�һ����ʱ%d����%n", threadNumber, insertTime, end-start);
    }
}