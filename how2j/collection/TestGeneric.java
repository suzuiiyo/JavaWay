package collection;

import java.util.ArrayList;

import charactor.Hero;
import charactor1.ADHero;
import charactor1.APHero;

public class TestGeneric {
    public static void main(String[] args) {
        ArrayList<APHero> heros = new ArrayList<APHero>();

        //只有APHero可以放进去
        heros.add(new APHero());

        //ADHero甚至放不进去
        //heros.add(new ADHero());

        //获取的时候也不需要进行转型,因为取出来一定是APHero
        APHero apHero = heros.get(0);
        for(Hero h : heros){
            System.out.println(h);
        }
        System.out.println("\t *****************\n");

        ArrayList<Hero> heros2 = new ArrayList<Hero>();
        //只有作为Hero的子类可以放进去
        heros2.add(new APHero());
        heros2.add(new ADHero());

        //和Hero无关的类型Item还是放不进去
        //heros.add(new Item());
        for(Hero h : heros2){
            System.out.println(h);
        }
    }
}