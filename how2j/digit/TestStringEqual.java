package digit;

public class TestStringEqual {
    public static void main(String[] args){
        String str1 = "God said there should be light, then light there be.";
        String str2 = new String(str1);

        //==用域判断是否是同一个字符串对象
        System.out.println(str1 == str2);
    }
}