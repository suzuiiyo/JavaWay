package charactor;

public class Spider extends Animal {
    static String name = "֩��";

    @Override
    public void eat() {
        System.out.println("֩�벶ʳ��");
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