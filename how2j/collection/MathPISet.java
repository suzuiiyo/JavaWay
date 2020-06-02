package collection;

import java.util.LinkedHashSet;
import java.util.Set;

public class MathPISet {
    public static void main(String[] args) {
        System.out.println(Math.PI);
        String str = String.valueOf(Math.PI);
        char[] arrPI = str.toCharArray();
        Set<Integer> PIset = new LinkedHashSet<>();
        for(char c : arrPI){
            PIset.add((int)(c - '0'));
            PIset.remove((int)('.'-'0'));
        }
        System.out.println(PIset);
        System.out.println("\n\t ************* \n");

        LinkedHashSet<Integer> PIset2 = new LinkedHashSet<>();
        double pi = Math.PI;
        while(PIset2.size()<10){
            PIset2.add((Integer)(int)(pi%10));
            pi*=10;
        }
        System.out.println(PIset2);
    }
}