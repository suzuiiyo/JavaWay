package digit;

public class TestString {
    public static void main(String[] args){
        int i = 5;

        //����1
        String str = String.valueOf(i);

        //����2
        Integer it = i;
        String str2 = it.toString();

        System.out.println(str + 3);
        System.out.println(str2 + 3);
    }
}