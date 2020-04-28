package digit;

public class TestStringEqual2 {
    public static void main(String[] args){
        String str1 = "the light";
        String str2 = new String(str1);
        String str3 = str1.toUpperCase();
        String str4 = "the light";

        //用于判断是否是同一个字符串对象
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str1==str3);
        System.out.println(str1.equals(str4));
        System.out.println(str1.equalsIgnoreCase(str3));
    }
}