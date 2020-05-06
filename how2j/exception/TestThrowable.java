package exception;

public class TestThrowable {
    public static void main(String[] args){
        try{
            throwCheck(2);
        }
        catch(Throwable e){                             //catch��ʱ��үҪ��Throwable��
            System.out.println("�׳�Throwable�쳣");
            e.printStackTrace();
        }
        throwRun(-3);
    }

    public static void throwCheck(int a) throws Throwable{   //�׳�Throwable��
        if(a > 0){
            throw new Exception("a");
        }
    }
    public static void throwRun(int a) {
        if(a > -1){
            throw new RuntimeException("a > -1");
        }
    }
}