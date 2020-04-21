package digit;

public class TestNumber {
    public static void main(String[] args){
        int i = 5;
        //把一个基本类型的变量，转换成Integer对象
        Integer it = new Integer(i);
        //把一个Integer对象，转换为一个基本类型的int
        //int i2 = it.intValue();
        System.out.println(it instanceof Number);
        int i2 = it.intValue();
        System.out.println(i2);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);    
    }
}