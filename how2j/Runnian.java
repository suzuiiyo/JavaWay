import java.util.Scanner;

public class Runnian{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("������һ�����: ");
        int i = s.nextInt();
        if(i%4==0){
            if(i%100==0){
                if(i%400==0){
                    System.out.println(i + "��������!");
                }else{
                    System.out.println(i +"�겻������");
                }
            }else{
                System.out.println(i +"�������꣡");
            }
        }
        s.close();
    }
}