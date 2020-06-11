package multithreading;

import charactor.Hero;

public class TestThread3 {
    public static void main(String[] args) {
        Hero beastMaster = new Hero();
        beastMaster.name = "兽王";
        beastMaster.hp = 616;
        beastMaster.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero karl = new Hero();
        karl.name = "卡尔";
        karl.hp = 455;
        karl.damage = 80;

        Battle battle1 = new Battle(beastMaster, teemo);
        new  Thread(battle1).start();
        Battle battle2 = new Battle(bh, karl);
        new Thread(battle2).start();
    }
}