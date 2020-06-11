package multithreading;

import charactor.Hero;
import exception.EnemyHeroIsDeadException;

public class TestThread4 {
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

        // 匿名类
        Thread t1 = new Thread() {
            public void run() {
                // 匿名类中用到外部的局部变量teemo，必须把teemo生命为final
                // 但是在JDK7以后，就不是必须加final了
                while (!teemo.isDead()) {
                    try {
                        beastMaster.attackHero(teemo);
                    } catch (EnemyHeroIsDeadException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                while(!karl.isDead()){
                    try {
                        bh.attackHero(karl);
                    } catch (EnemyHeroIsDeadException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
    }
}