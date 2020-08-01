package reflection;

public class TestReflection4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            public void run(){
                //����method1
                TestReflection4.method1();
            }
        };
        t1.setName("��һ���߳�");
        t1.start();

        //�ȴ�t1�����Ż�ִ��t2
        t1.join();

        Thread t2 = new Thread(){
            public void run(){
                TestReflection4.method2();
            }
        };
        t2.setName("�ڶ����߳�");
        t2.start();
    }

    public static void method1(){
        synchronized(TestReflection4.class){
            //����method1���ԣ�ͬ��������TestReflection.class,ֻ��ռ��TestReflection.class�ſ���ִ�е�����
            System.out.println(Thread.currentThread().getName());
            try{
                System.out.println("1����5��");
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("1111");
        }
    }

    //������method2
    /*public static synchronized void method2(){
        System.out.println(Thread.currentThread().getName());
        try{
            System.out.println("2����5��");
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }*/

    //��������method2    ����������print��ͬʱ��ӡ����
    public static void method2(){
        System.out.println(Thread.currentThread().getName());
        try{
            System.out.println("2����5��");
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}