package digit;
import java.util.Scanner;


public class Prime{

    private int count;
    public static void main(String[] args) {
        int amount = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("请输入取值范围: ");
        int n = s.nextInt();
        Prime num = new Prime();
        for(int i=2; i<n; i++){
            amount = num.judgePrime(i);
        }
        System.out.println("总共有" + amount + "个");
        s.close();
    }

    public int judgePrime(int m){
        boolean flag=true;
        if(m%2==0&&m!=2){
            System.out.println(m + "不是质数");
        }
        else{
            for(int h=3; h<=Math.sqrt(m); h+=2){
                if(m%h==0){
                    System.out.println(m + "不是质数");
                    flag = false;
                    break;
                }
            }
            if(flag){   
                System.out.println(m + "是质数");
                this.count++;
            }
        }
        return count;
    }
}