package charactor;
public class SPHero extends Hero{
    public static void heal(){
        System.out.println("heal the world!");
    }

    public static void heal(Hero h){
        h.hp++;
        System.out.println(h.name +"��hpΪ" + h.hp);
    }
    public static void heal(Hero h, int hp){
        h.hp += hp;
        System.out.println("Ϊ"+ h.name + "����" + hp +"��hp");
    }

    public static void main(String[] args){
        SPHero garen = new SPHero();
        garen.name = "�Ȼ�ħŮ";
        Hero teemo = new Hero();
        teemo.name = "��ҽ";
        Hero fatiao = new SPHero();
        fatiao.name = "�����ؾ�";

        heal();
        heal(garen);
        heal(teemo, 100);
        heal(fatiao, 300);
    }
}