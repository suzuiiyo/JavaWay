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
                    System.out.printf("�Ѿ�����%d��%n", seconds++);
                }
            }
        };
        t1.start();

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

        Thread t2 = new Thread() {
            public void run() {
                while (!teemo.isDead()) {
                    try {
                        beastMaster.attackHero(teemo);
                    } catch (EnemyHeroIsDeadException e) {
                        System.out.println(teemo.name + "��͹����ˣ�");
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();

        try{
            //t1�̲߳main�߳�֮ǰ��ֻ��t1�߳����н���,�Ż����������
            t1.join();
            //TODO join�߳�t2
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        Thread t3 = new Thread(){
            public void run(){
                while(!karl.isDead()){
                    try {
                        bh.attackHero(karl);
                    } catch (EnemyHeroIsDeadException e) {
                        System.out.println(karl.name + "��͹����ˣ�");
                        e.printStackTrace();
                    }
                }
            }
        };
        t3.start();
    }
}