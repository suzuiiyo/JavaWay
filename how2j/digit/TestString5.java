package digit;

public class TestString5 {
    public static void main(String[] args){
        char[] ch = new char[10];
        for(int i=0; i<ch.length; i++){
            int num = (int)(Math.random()*100);
            ch[i] = (char)num;
            System.out.print(ch[i] + "_");
        }
        System.out.println("\n" + "´òÓ¡Íê±Ï");
    }
}