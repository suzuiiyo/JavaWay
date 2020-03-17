public class SPHero extends Hero{
    public static void heal(){
        System.out.println("heal the world!");
    }

    public static void heal(Hero h){
        h.hp++;
        System.out.println("为"+ h.name +"治疗");
    }
    public static void heal(Hero h, int hp){
        h.hp += hp;
        System.out.println("为"+ h.name + "治疗" + hp +"点hp");
    }

    public static void main(String[] args){
        SPHero garen = new SPHero();
        Hero teemo = new Hero();
        SPHero fatiao = new SPHero();

        heal();
        heal(garen);
        heal(teemo, 100);
        heal(fatiao, 300);
    }
}