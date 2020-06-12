package multithreading;

import charactor.Hero;
import exception.EnemyHeroIsDeadException;

public class TestThreadPriority {
    public static void main(String[] args) {
        Hero beastMaster = new Hero();
        beastMaster.name = "����";
        beastMaster.hp = 616;
        beastMaster.damage = 10;

        Hero teemo = new Hero();
        teemo.name = "��Ī";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "�ͽ�";
        bh.hp = 500;
        bh.damage = 10;

        Hero karl = new Hero();
        karl.name = "����";
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
                        //TODO��ʱ��ͣ,ʹ��t1����ռ��CPU��Դ
                        Thread.yield();
                        bh.attackHero(karl);
                    } catch (EnemyHeroIsDeadException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //�����ȼ���Ϊͬ��
        t1.setPriority(5);
        t2.setPriority(5);
        //t1.setPriority(Thread.MAX_PRIORITY);            //ǰ����CPU��Դ���ޣ����߳�֮��Ż����ֳ��о���
        //t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}