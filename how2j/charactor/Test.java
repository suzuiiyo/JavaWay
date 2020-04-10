package charactor;

public class Test {
    public void method1(){
        System.out.println("调用对象方法");
    }
    public static void method2(Test test){
        System.out.println("调用类方法");
        test.method1();//利用传参数的方法调用对象方法
        //this.method1();
            //method1();
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.method1();
        Test.method2(test);
    }
}