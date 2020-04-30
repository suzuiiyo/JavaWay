package date;
import java.util.Date;

public class TestDate {
    public static void main(String[] args){
        Date now = new Date();
        //打印当前时间
        System.out.println("当前时间：" + now.toString());
        //getTime()得到一个long型的整数
        System.out.println("当前时间Date.getTime()返回的值是: " + now.getTime());
        System.out.println("当前时间System.currentTimeMillis()返回的值是: " + System.currentTimeMillis());

        Date zero = new Date(0);
        System.out.println("用0作为构造参数,得到的日期是：" + zero);
    }
}