package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import charactor.Hero;

public class TestLambda3 {
    public static void main(String[] args) {
        List<Hero> herolist = new ArrayList<>();
        Random r = new Random();
        for(int i=0; i<10; i++){
            herolist.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("��ʼ����ļ���: ");
        System.out.println(herolist);
        System.out.println("ʹ�����ö��󷽷��Ĺ��˽��: ");             //����������÷Ǿ�̬����
        TestLambda3 heroLambda3 = new TestLambda3();
        filter(herolist, heroLambda3::testHero);

        System.out.println("Lambda���ʽ�е��������еĶ����matched������");            //lambda���ʽ����������������ķ���
        filter(herolist, h->h.matched());

        System.out.println("���������ж���ķ��� �Ĺ��˽��: ");     //matched����ǡ������������Hero�ķ���
        filter(herolist, Hero::matched);

    }

    private static void filter(List<Hero> herolist, HeroChecker checker){
        for(Hero h : herolist){
            if(checker.test(h))
                System.out.println(h);
        }
    }
    
    public boolean testHero(Hero h){            //�Ǿ�̬����,�ȴ��������ڵ���
        return h.hp>100&&h.damage<50;           //���������������,��ʵ��Ϊ�˽�һ����lambda���ʽ
    }
}