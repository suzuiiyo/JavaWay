//package charactor;

public class Hero3{
    public String name;
    protected float hp;

    public static void main(String[] args) {
        Hero h1 =  new Hero();
        Hero h2 =  new Hero();
        Hero h3;
        Hero h4;
        h3 = h1;
        h4 = h3;
    }
}