package digit;

public class TestString3 {
    public static void main(String[] args){
        String swordwoman = "½£¼§";
        String teemo = new String("±ùÅ®");
        char[] cs = new char[]{'ÜÔ', '´Þ', 'µÙ'};
        String hero = new String(cs);
        String hero3 = swordwoman + teemo;

        System.out.println(hero3);
        System.out.println(hero);
    }
}