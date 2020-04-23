package digit;
import java.util.Scanner;

public class TestChar3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("ÇëÊäÈë×Ö·û´®");
        String str = s.nextLine();
        char[] ch = str.toCharArray();
        s.close();

        for(int i=0; i<ch.length; i++){
            Character c = ch[i];
            if(Character.isDigit(c)||Character.isUpperCase(c)){
                System.out.println(c);
            }
        }
    }
}