package multithreading;

import charactor.Hero;
import exception.EnemyHeroIsDeadException;

public class TestThreadPriority {
    public static void main(String[] args) {
        Hero beastMaster = new Hero();
        beastMaster.name = "兽王";
        beastMaster.hp = 616;
        beastMaster.damage = 10;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金";
        bh.hp = 500;
        bh.damage = 10;

        Hero karl = new Hero();
        karl.name = "卡尔";
        karl.hp = 455;
        karl.damage = 80;

        Thread t1 = new Thread() {
            public void run() {
                while (!teemo.isDead()) {
                    try {
                        beastMaster.attackHero(teemo);
                    } catch (EnemyHeroIsDeadException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                while (!karl.isDead()) {
                    try {
                        //TODO临时暂停,使得t1可以占用CPU资源
                        Thread.yield();
                        bh.attackHero(karl);
                    } catch (EnemyHeroIsDeadException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //将优先级设为同级
        t1.setPriority(5);
        t2.setPriority(5);
        //t1.setPriority(Thread.MAX_PRIORITY);            //前提是CPU资源有限，各线程之间才会体现出有竞争
        //t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}