package digit;

public class TsetSubString {
    public static void main(String[] args){
        String str1 = "the light";
        String start = "the";
        String end = "Ight";

        System.out.println(str1.startsWith(start));//以。。开始
        System.out.println(str1.endsWith(end)); //以。。结束
    }
}