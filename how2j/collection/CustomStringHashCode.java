package collection;

import java.util.Random;

public class CustomStringHashCode {
    public static void main(String[] args) {
        Random rand = new Random();
        char[] ch = new char[1000];
        /*for(int i=0; i<100; i++){
            int len = rand.nextInt(10-2+1)+2;
            while(len>0){
                str[i] += String.valueOf((char)(rand.nextInt(122-30+1)+30));
                len--;
            }
            System.out.println(str[i]);
        }*/
        for(int i=0; i<ch.length; i++){
            ch[i] = (char)(rand.nextInt(122-48+1)+48);
        }
        String str = String.valueOf(ch);
        String[] str2 = new String[100];
        for(int i=0; i<100; i++){
            int start = rand.nextInt(989-0+1);
            int end = start + (rand.nextInt(10-2+1)+2);
            str2[i] = str.substring(start, end);
            System.out.print(str2[i] + "   ");
        }

        System.out.println("\n\n\t *************\n");

        int[] strCode = new int[100];
        for(int i=0; i<str2.length; i++){
            strCode[i] = hashcode(str2[i]);
            System.out.print(strCode[i] + "    ");
        }
    }

    public static int hashcode(String str){
        if(str.length()==0){
            return 0;
        }else{
            int recode=0;
            char[] ch = str.toCharArray();
            for(char c : ch){
                recode += (int)c;
                recode *= 23;
                if(recode>1999){
                    recode = recode%2000;
                }else if(recode<0){
                    recode = Math.abs(recode);
                }
            }
            return recode;
        }
    }
}