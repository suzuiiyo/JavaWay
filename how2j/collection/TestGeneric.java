package collection;

import java.util.ArrayList;

import charactor.Hero;
import charactor1.ADHero;
import charactor1.APHero;

public class TestGeneric {
    public static void main(String[] args) {
        ArrayList<APHero> heros = new ArrayList<APHero>();

        //ֻ��APHero���ԷŽ�ȥ
        heros.add(new APHero());

        //ADHero�����Ų���ȥ
        //heros.add(new ADHero());

        //��ȡ��ʱ��Ҳ����Ҫ����ת��,��Ϊȡ����һ����APHero
        APHero apHero = heros.get(0);
        for(Hero h : heros){
            System.out.println(h);
        }
        System.out.println("\t *****************\n");

        ArrayList<Hero> heros2 = new ArrayList<Hero>();
        //ֻ����ΪHero��������ԷŽ�ȥ
        heros2.add(new APHero());
        heros2.add(new ADHero());

        //��Hero�޹ص�����Item���ǷŲ���ȥ
        //heros.add(new Item());
        for(Hero h : heros2){
            System.out.println(h);
        }
    }
}