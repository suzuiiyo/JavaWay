package digit;
import java.util.Scanner;

public class JudgePrime {
    public void judgePrime(int m){
        boolean flag = true;
        if(m%2==0&&m!=2){
            System.out.println(m + "不是质数");
        }
        else{
            for(int h=2; h<=Math.sqrt(m); h++){
                if(m%h==0&&h>=2){
                    System.out.println(m + "不是质数");
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(m + "是质数");
            }
        }
    }

    public static void main(String[] args) {
        int m;
        Scanner s = new Scanner(System.in);
        System.out.println("请输入一个大于1的正整数: ");
        m = s.nextInt();
        s.close();
        JudgePrime num = new JudgePrime();
        num.judgePrime(m);
    }
}