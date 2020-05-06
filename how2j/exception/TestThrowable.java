package exception;

public class TestThrowable {
    public static void main(String[] args){
        try{
            throwCheck(2);
        }
        catch(Throwable e){                             //catch的时候爷要是Throwable类
            System.out.println("抛出Throwable异常");
            e.printStackTrace();
        }
        throwRun(-3);
    }

    public static void throwCheck(int a) throws Throwable{   //抛出Throwable类
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