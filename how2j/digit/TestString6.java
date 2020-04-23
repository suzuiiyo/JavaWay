package digit;

import java.util.Random;

public class TestString6 {
    public static void main(String[] args){
        String[] str = new String[8];
        char[] str2 = new char[5];
        Random rand = new Random();
        for(int j=0; j<str.length;j++){
            for(int i=0; i<str2.length; i++){
                int num = rand.nextInt(58)+65;
                if((num<91||num>96)){
                    str2[i] = (char)(num);
                }
                System.out.print(num + " ");
            }
            str[j] = String.valueOf(str2);  //×Ö·ûÊý×é×ª»»³É×Ö·û´®j
            System.out.println(str[j]);
        }
        System.out.println("**********************");
        for(int k=0; k<str.length; k++){
            char[] str3 = str[k].toCharArray();    //×Ö·û´®×ª»»³É×Ö·ûÊý×é
            for(int l=1; l<str3.length; l++){       //Ã°ÅÝÅÅÐò·¨
                for(int m=0; m<str3.length-l; m++){
                    int num3 = (int)str3[m];
                    int num4 = (int)str3[m+1];
                    if(num3>num4){
                        char temp = str3[m];
                        str3[m] = str3[m+1];
                        str3[m+1] = temp;
                    }
                }
            }
            for(int i=0; i<str3.length; i++){
                int[] num5 = new int[5];
                num5[i] = (int)str3[i];
                System.out.print(num5[i] + " ");
            }
            str[k] = String.valueOf(str3);
            System.out.println(str[k]);
        }
    }
}