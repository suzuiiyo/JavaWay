package multithreading;

import charactor.Hero;
import exception.EnemyHeroIsDeadException;

public class TestThreadJoin {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                int seconds = 0;
                while (seconds<10) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("已经进行%d秒%n", seconds++);
                }
            }
        };
        t1.start();

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

        Thread t2 = new Thread() {
            public void run() {
                while (!teemo.isDead()) {
                    try {
                        beastMaster.attackHero(teemo);
                    } catch (EnemyHeroIsDeadException e) {
                        System.out.println(teemo.name + "早就挂求了！");
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();

        try{
            //t1线程差到main线程之前，只有t1线程运行结束,才会继续往下走
            t1.join();
            //TODO join线程t2
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        Thread t3 = new Thread(){
            public void run(){
                while(!karl.isDead()){
                    try {
                        bh.attackHero(karl);
                    } catch (EnemyHeroIsDeadException e) {
                        System.out.println(karl.name + "早就挂求了！");
                        e.printStackTrace();
                    }
                }
            }
        };
        t3.start();
    }
}