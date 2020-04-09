package charactor;

public class ADHero extends Hero{
    public static void main(String[] args){
        ADHero bh = new ADHero();
        bh.name = "赏金猎人";

        Hero h1 = new Hero();
        h1.name = "沉默术士";
        Hero h2 = new Hero();
        h2.name = "流浪剑客";

        bh.attack(h1);
        bh.attack(h1, h2);
    }
    /* public void attack(){
        System.out.println(name + "进行了一次攻击，但是不确定打中了谁");
    }
    public void attack(Hero h1){
        System.out.println(name + "对" + h1.name + "进行了一次攻击");
    }
    public void attack(Hero h1, Hero h2){
        System.out.println(name + "同时对" + h1.name + "和" +h2.name + "进行了攻击");
    }
    */
    public void attack(Hero... heros){
        for(int i=0; i<heros.length; i++){
            System.out.println(name + "攻击了" + heros[i].name);
        }
    }
}