package digit;

import java.util.Scanner;

public class Log {
    public static void main(String[] args){
        double e =0;
        Scanner s = new Scanner(System.in);
        System.out.println("������һ������: ");
        double delta = s.nextDouble();
        for(int n=1; n<1.0/delta; n++){
            e = Math.pow(1+1.0/n, n);
            if(Math.abs(Math.E-e)>delta){
                delta = Math.abs(Math.E - e);
            }
            System.out.println(e);
        }
        System.out.println("e: " +e);
        System.out.println("��Ȼ������" +Math.E);
        s.close();
    }
}