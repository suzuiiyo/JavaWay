package charactor;

public class Hero2 {
    public String name;
    protected float hp;
    static String copyright;

    public static void main(String[] args) {
        Hero2 garen =  new Hero2();
        garen.name = "BJ winter";

        Hero2.copyright = "the copyright belongs to Akiina";

        System.out.println(garen.name);
        System.out.println(Hero2.copyright);

        Hero2.copyright = "Akiina owns the copyright";

        Hero2 teemo = new Hero2();
        teemo.name = "meguri";
        System.out.println(teemo.name);
        System.out.println(Hero2.copyright);
    }
}