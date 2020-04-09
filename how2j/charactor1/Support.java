package charactor1;
import charactor.Hero;

public class Support extends Hero{
    public void heal(){
        System.out.println("救治自己！");
    }

    public void heal(Hero hero){
        System.out.println("给英雄" + hero + "加油");
    }

    public void heal(Hero hero, int hp){
        System.out.println("给英雄" + hero + "恢复" + hp + "点生命");
    }
}