package multithreading;

import charactor.Hero;
import exception.EnemyHeroIsDeadException;

public class TestThread4 {
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

        // ������
        Thread t1 = new Thread() {
            public void run() {
                // ���������õ��ⲿ�ľֲ�����teemo�������teemo����Ϊfinal
                // ������JDK7�Ժ󣬾Ͳ��Ǳ����final��
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