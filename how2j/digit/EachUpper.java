package digit;
import java.util.Scanner;


public class EachUpper {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入一个英文句子: ");
        String sentence = s.nextLine();
        //System.out.println(sentence);
        s.close();
        char[] letter = sentence.toCharArray();
        letter[0]=Character.toUpperCase(letter[0]);
        for(int i=1; i<letter.length; i++){
            if(letter[i]==' '){
                letter[i+1]=Character.toUpperCase(letter[i+1]);
            }
        }
        sentence = String.valueOf(letter);
        System.out.println(sentence);
    }
}