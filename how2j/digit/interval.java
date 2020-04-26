package digit;
import java.util.Scanner;

public class interval {
    public static void main(String[] args){
        Scanner word = new Scanner(System.in);
        System.out.println("请输入一个英文单词: ");
        String s = word.nextLine();
        word.close();

        char[] letter = s.toCharArray();
        for(int i=0; i<letter.length; i++){
            if(i%2==0){
                letter[i]=Character.toUpperCase(letter[i]);
            }
        }
        s = String.valueOf(letter);
        System.out.println("\n" +"***************************" +"\n");
        System.out.println("转换之后的单词为：" + s);
    }   
}