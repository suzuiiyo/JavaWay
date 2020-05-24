package matrix;

import java.util.ArrayList;

public class Power {
    public static void main(String[] args){
        ArrayList que = new ArrayList();
        int sum  = 0;
        for(int i=0; i<100; i++){
            while(sum < 100){
                sum += i;
                que.add(i);
                break;
            }
        }
        System.out.println(que);
        System.out.println(sum);
    }
}