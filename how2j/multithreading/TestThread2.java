package multithreading;

import charactor.Hero;

public class TestThread2 {
    public static void main(String[] args) {
        Hero beastMaster = new Hero();
        beastMaster.name = "????";
        beastMaster.hp = 616;
        beastMaster.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "?¨¢??";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "????????";
        bh.hp = 500;
        bh.damage = 65;

        Hero karl = new Hero();
        karl.name = "?¡§??";
        karl.hp = 455;
        karl.damage = 80;

        KillThread killThread1 = new KillThread(beastMaster, teemo);
        killThread1.start();
        KillThread killThread2 = new KillThread(bh, karl);
        killThread2.start();
    }
}