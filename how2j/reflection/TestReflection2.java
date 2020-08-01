package reflection;

public class TestReflection2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                //����method1
                TestReflection2.method1();
            }
        };
        t1.setName("��һ���߳�");
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                TestReflection2.method2();
            }
        };
        t2.setName("�ڶ����߳�");
        t2.start();
    }

    public static void method1(){
        synchronized(TestReflection2.class){
            //method1ռ�������
            System.out.println(Thread.currentThread().getName() + "������method1����");
            try{
                System.out.println("����5��");
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static synchronized void method2(){
        //��ִ��method1,ռ��TestReflection2.class���method2����ȴ��Ϳ��Խ���֤��ռ�õĲ���TestReflection2.class����֮����
        System.out.println(Thread.currentThread().getName() + "����method2����");
        try{
            System.out.println("����5��");
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}