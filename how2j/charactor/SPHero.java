package charactor;
public class SPHero extends Hero{
    public static void heal(){
        System.out.println("heal the world!");
    }

    public static void heal(Hero h){
        h.hp++;
        System.out.println(h.name +"的hp为" + h.hp);
    }
    public static void heal(Hero h, int hp){
        h.hp += hp;
        System.out.println("为"+ h.name + "治疗" + hp +"点hp");
    }

    public static void main(String[] args){
        SPHero garen = new SPHero();
        garen.name = "魅惑魔女";
        Hero teemo = new Hero();
        teemo.name = "巫医";
        Hero fatiao = new SPHero();
        fatiao.name = "发条地精";

        heal();
        heal(garen);
        heal(teemo, 100);
        heal(fatiao, 300);
    }
}