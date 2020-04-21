package charactor;

public class Spider extends Animal {
    static String name = "Ö©Öë";

    @Override
    public void eat() {
        System.out.println("Ö©Öë²¶Ê³Äñ");
    }

    public Spider() {
        super(8, name);
    }
    public static void main(String[] args){
        Spider axx = new Spider();
        axx.eat();
        axx.walk();
    }
}