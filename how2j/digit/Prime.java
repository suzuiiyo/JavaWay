package digit;
import java.util.Scanner;


public class Prime{

    private int count;
    public static void main(String[] args) {
        int amount = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("������ȡֵ��Χ: ");
        int n = s.nextInt();
        Prime num = new Prime();
        for(int i=2; i<n; i++){
            amount = num.judgePrime(i);
        }
        System.out.println("�ܹ���" + amount + "��");
        s.close();
    }

    public int judgePrime(int m){
        boolean flag=true;
        for(int h=2; h<=Math.sqrt(m); h++){
            if(m%h==0&&h>=2){
                System.out.println(m + "��������");
                flag = false;
                break;
            }
        }
        if(flag){   
            System.out.println(m + "������");
            this.count++;
        }
        return count;
    }
}