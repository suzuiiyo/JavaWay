package reflection;

public class TestReflection4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            public void run(){
                //调用method1
                TestReflection4.method1();
            }
        };
        t1.setName("第一个线程");
        t1.start();

        //等待t1死亡才会执行t2
        t1.join();

        Thread t2 = new Thread(){
            public void run(){
                TestReflection4.method2();
            }
        };
        t2.setName("第二个线程");
        t2.start();
    }

    public static void method1(){
        synchronized(TestReflection4.class){
            //对于method1而言，同步对象是TestReflection.class,只有占用TestReflection.class才可以执行到这里
            System.out.println(Thread.currentThread().getName());
            try{
                System.out.println("1运行5秒");
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("1111");
        }
    }

    //加锁的method2
    /*public static synchronized void method2(){
        System.out.println(Thread.currentThread().getName());
        try{
            System.out.println("2运行5秒");
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }*/

    //不加锁的method2    两个方法的print会同时打印出来
    public static void method2(){
        System.out.println(Thread.currentThread().getName());
        try{
            System.out.println("2运行5秒");
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}