package reflection;

public class TestReflection2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                //调用method1
                TestReflection2.method1();
            }
        };
        t1.setName("第一个线程");
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                TestReflection2.method2();
            }
        };
        t2.setName("第二个线程");
        t2.start();
    }

    public static void method1(){
        synchronized(TestReflection2.class){
            //method1占用类对象
            System.out.println(Thread.currentThread().getName() + "进入了method1方法");
            try{
                System.out.println("运行5秒");
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static synchronized void method2(){
        //先执行method1,占用TestReflection2.class如果method2无需等待就可以进入证明占用的不是TestReflection2.class，反之则是
        System.out.println(Thread.currentThread().getName() + "进入method2方法");
        try{
            System.out.println("运行5秒");
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}