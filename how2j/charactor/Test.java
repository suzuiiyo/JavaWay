package charactor;

public class Test {
    public void method1(){
        System.out.println("���ö��󷽷�");
    }
    public static void method2(Test test){
        System.out.println("�����෽��");
        test.method1();//���ô������ķ������ö��󷽷�
        //this.method1();
            //method1();
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.method1();
        Test.method2(test);
    }
}