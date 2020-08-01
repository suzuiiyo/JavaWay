package reflection;

public class TestReflection3 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Thread t1 = new Thread() {
                public void run() {
                    TestReflection3.test();
                    TestReflection3.test2();
                }
            };
            t1.start();
        }

        //try {
            //Class.forName()会抛出异常
          //  Class c1 = Class.forName("TestReflection3");
            Class c2 = TestReflection3.class;
            Class c3 = new TestReflection3().getClass();
            
            //System.out.println(c1 == c2);
            System.out.println(c2 == c3);
        //} catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
          //  e.printStackTrace();
        //}
    }

    public static synchronized void test(){
        System.out.println("苍天已死，黄巾当立");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void test2(){
        System.out.println("岁在甲子，天下大吉");
    }
}