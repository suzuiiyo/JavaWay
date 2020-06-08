package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import charactor.Hero;

public class TestLambda {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for(int i =0; i < 5; i++){
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("��ʼ����ļ���: ");
        System.out.println(heros);
        //System.out.println("ʹ��������ķ�ʽ,ɸѡ��hp>100 && damage<50��Ӣ��");
        //System.out.println("ʹ��lambda��ʽ,ɸѡ��hp>100 && damage<50��Ӣ��");

        //System.out.println("ʹ�����ö��󷽷� �Ĺ��˽��");
        //ʹ����Ķ��󷽷�
        //TestLambda testLambda = new TestLambda();
        //filter(heros, testLambda::testHero);

        HeroChecker checker = new HeroChecker(){
            @Override
            public boolean test(Hero h){
                return (h.hp>100&&h.damage<50);
            }
        };
        System.out.println("ʹ�����������");               
        filter(heros, checker);
        System.out.println("ʹ��Lambda���ʽ");
        filter(heros, h->h.hp>100&&h.damage<50);
        System.out.println("��Lambda���ʽ��ʹ�þ�̬����");         
        filter(heros, h->TestLambda.testHero(h));
        System.out.println("ֱ�����ú;�̬����");
        filter(heros, TestLambda::testHero);
    }

    private static void filter(List<Hero> heros, HeroChecker checker){          //��̬����������
        for(Hero hero : heros){
            if(checker.test(hero))
                System.out.println(hero);
        }
    }

    //���þ�̬����
    public static boolean testHero(Hero h){                 //��̬����������lambda���ʽ��ֱ�ӵ���
    //public boolean testHero(Hero h){
        return h.hp>100&&h.damage<50;
    }
}