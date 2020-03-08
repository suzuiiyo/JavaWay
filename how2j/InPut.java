import java.util.Scanner;

public class InPut{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入整数");
        int i = s.nextInt();
        System.out.println("读取的整数是" + i);
        System.out.println("请输入字符串");
        String rn = s.nextLine();
        String a = s.nextLine();
        //System.out.println("读取的字符串是: " + rn);
        System.out.println("读取的字符串是: " + a);
    }
}