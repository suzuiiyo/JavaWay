package digit;
import java.util.Scanner;


public class Prime{

    private int count;
    public static void main(String[] args) {
        int amount = 0;
        long start = System.currentTimeMillis();
        Scanner s = new Scanner(System.in);
        System.out.println("������ȡֵ��Χ: ");
        int n = s.nextInt();
        Prime num = new Prime();
        for(int i=2; i<n; i++){
            amount = num.judgePrime(i);
        }
        System.out.println("�ܹ���" + amount + "������");
        s.close();
        long end = System.currentTimeMillis();
        System.out.println("����ʱ��" + (end - start)/1000 + "��");
    }

    public int judgePrime(int m){
        boolean flag=true;
        if(m%2==0&&m!=2){
            //System.out.println(m + "��������");
        }
        else{
            for(int h=3; h<=Math.sqrt(m); h+=2){
                if(m%h==0){
                    //System.out.println(m + "��������");
                    flag = false;
                    break;
                }
            }
            if(flag){   
                //System.out.println(m + "������");
                this.count++;
            }
        }
        return count;
    }
}