package multithreading;

import charactor.Hero;

public class TestThread3 {
    public static void main(String[] args) {
        Hero beastMaster = new Hero();
        beastMaster.name = "����";
        beastMaster.hp = 616;
        beastMaster.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "��Ī";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "�ͽ�����";
        bh.hp = 500;
        bh.damage = 65;

        Hero karl = new Hero();
        karl.name = "����";
        karl.hp = 455;
        karl.damage = 80;

        Battle battle1 = new Battle(beastMaster, teemo);
        new  Thread(battle1).start();
        Battle battle2 = new Battle(bh, karl);
        new Thread(battle2).start();
    }
}