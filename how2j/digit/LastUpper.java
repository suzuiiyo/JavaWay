package digit;
import java.util.Scanner;

public class LastUpper {
    public static void main(String[] args){
        Scanner word = new Scanner(System.in);
        System.out.println("������һ��Ӣ�ĵ���: ");
        String s = word.nextLine();
        word.close();

        char[] letter = s.toCharArray();
        for(int i=0; i<letter.length; i++){
            if(i==letter.length-1){
                letter[i]=Character.toUpperCase(letter[i]);
            }
        }
        s = String.valueOf(letter);
        System.out.println("\n" +"***************************" +"\n");
        System.out.println("ת��֮��ĵ���Ϊ��" + s);
    }   
}