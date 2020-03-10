import java.util.Scanner;

public class Runnian{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入一个年份: ");
        int i = s.nextInt();
        if(i%4==0){
            if(i%100==0){
                if(i%400==0){
                    System.out.println(i + "年是闰年!");
                }else{
                    System.out.println(i +"年不是闰年");
                }
            }else{
                System.out.println(i +"年是闰年！");
            }
        }
        s.close();
    }
}