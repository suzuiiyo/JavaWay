package charactor;

public class Hero9 {
    public String name;
    protected float hp;

    public boolean equals(Object o){
        if(o instanceof Hero){
            Hero h = (Hero) o;
            return this.hp == h.hp;
        }
        return false;
    }

    /*public String toString(){
        return name;
    }

    public void finalize(){
        System.out.println("这个英雄正在被回收");
    }*/

    public static void main(String[] args){
        /*Hero h;
        for (int i =0; i <100000; i++){
            h = new Hero();
        }*/

        Hero h1 = new Hero();
        h1.hp = 300;
        Hero h2 = new Hero();
        h1.hp = 400;
        Hero h3 = new Hero();
        h3.hp = 300;

        System.out.println(h1.equals(h2));
        System.out.println(h1.equals(h3));
        System.out.println(h1==h2);
        System.out.println(h1==h3);
    }
}