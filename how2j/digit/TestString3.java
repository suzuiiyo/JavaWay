package digit;

public class TestString3 {
    public static void main(String[] args){
        String swordwoman = "����";
        String teemo = new String("��Ů");
        char[] cs = new char[]{'��', '��', '��'};
        String hero = new String(cs);
        String hero3 = swordwoman + teemo;

        System.out.println(hero3);
        System.out.println(hero);
    }
}