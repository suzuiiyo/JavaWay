package digit;
import java.util.Scanner;

public class Replace {
    public static void main(String[] args){
        Scanner sentence = new Scanner(System.in);
        System.out.println("������һ��Ӣ�ľ���: ");
        String s = sentence.nextLine();
        sentence.close();

        //String s1 = s.replace("two", "one");
        int x = s.lastIndexOf("two");
        char[] letter = s.toCharArray();
        letter[x] = Character.toUpperCase(letter[x]);
        String s1 = String.valueOf(letter);
        System.out.println("\n" +"***************************" +"\n");
        System.out.println("ת��֮���Ϊ��" + s1);
    } 
}