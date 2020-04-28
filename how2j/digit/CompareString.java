package digit;
import java.util.Random;

public class CompareString {
    public static void main(String[] args){
        String[] str = new String[100];
        Random rand = new Random();
        int count = 0;
        for(int i=0; i<str.length; i++){
            int num = rand.nextInt(26)+33;
            int num2 = rand.nextInt(26)+33;
            str[i] = String.valueOf((char)num) + String.valueOf((char)num2);
        }
        for(int j=0; j<=str.length-1; j++){
            for(int k=j+1; k<str.length-1; k++){
                if(str[j].equals(str[k])){
                    System.out.println(str[j] +"="+ str[k]);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}