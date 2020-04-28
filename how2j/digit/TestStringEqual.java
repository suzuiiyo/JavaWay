package digit;

public class TestStringEqual {
    public static void main(String[] args){
        String str1 = "God said there should be light, then light there be.";
        String str2 = new String(str1);
        String str7 = str1;

        //==用域判断是否是同一个字符串对象
        System.out.println(str1 == str2);
        System.out.println(str1 == str7);


        int str3 = 777;
        int str4 = str3;
        //==用域判断是否是同一个字符串对象
        System.out.println(str3 == str4);

        char str5 = 'a';
        char str6 = str5;
        //==用域判断是否是同一个字符串对象
        System.out.println(str3 == str6);
    }
}