package multithreading;

import charactor.Hero;
import exception.EnemyHeroIsDeadException;

public class TestThread {
    public static void main(String[] args) throws EnemyHeroIsDeadException {
        Hero beastMaster = new Hero();
        beastMaster.name = "ÊÞÍõ";
        beastMaster.hp = 616;
        beastMaster.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "ÌáÄª";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "ÉÍ½ðÁÔÈË";
        bh.hp = 500;
        bh.damage = 65;

        Hero karl = new Hero();
        karl.name = "¿¨¶û";
        karl.hp = 455;
        karl.damage = 80;

        //ÊÞÍõ¹¥»÷ÌáÄª
        while(!teemo.isDead()){                     //µ¥Ïß³Ì
            beastMaster.attackHero(teemo);
        }

        //ÉÍ½ðÁÔÈË¹¥»÷¿¨¶û
        while(!karl.isDead()){
            bh.attackHero(karl);
        }
    }
}