package digit;
import java.util.Scanner;

public class JudgePrime {
    public void judgePrime(int m){
        boolean flag = true;
        if(m%2==0&&m!=2){
            System.out.println(m + "��������");
        }
        else{
            for(int h=2; h<=Math.sqrt(m); h++){
                if(m%h==0&&h>=2){
                    System.out.println(m + "��������");
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(m + "������");
            }
        }
    }

    public static void main(String[] args) {
        int m;
        Scanner s = new Scanner(System.in);
        System.out.println("������һ������1��������: ");
        m = s.nextInt();
        s.close();
        JudgePrime num = new JudgePrime();
        num.judgePrime(m);
    }
}