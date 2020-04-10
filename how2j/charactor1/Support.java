package charactor1;
import charactor.Hero;

public class Support extends Hero implements healer{
    public void heal(){
        System.out.println("救治自己！");
    }

    public void heal(Hero hero){
        System.out.println("给英雄" + hero.name + "治疗");
    }

    public void heal(Hero hero, int hp){
        System.out.println("给英雄" + hero.name + "恢复" + hero.hp + "点生命");
    }
    public static void main(String[] args){
        Support Wyi = new Support();
        Hero teemo = new Hero();
		Wyi.heal(teemo);
    }
}