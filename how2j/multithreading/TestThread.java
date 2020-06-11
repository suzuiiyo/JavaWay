package multithreading;

import charactor.Hero;
import exception.EnemyHeroIsDeadException;

public class TestThread {
    public static void main(String[] args) throws EnemyHeroIsDeadException {
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

        //����������Ī
        while(!teemo.isDead()){                     //���߳�
            beastMaster.attackHero(teemo);
        }

        //�ͽ����˹�������
        while(!karl.isDead()){
            bh.attackHero(karl);
        }
    }
}