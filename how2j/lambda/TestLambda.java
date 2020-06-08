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
        System.out.println("初始化后的集合: ");
        System.out.println(heros);
        //System.out.println("使用匿名类的方式,筛选出hp>100 && damage<50的英雄");
        //System.out.println("使用lambda方式,筛选出hp>100 && damage<50的英雄");

        //System.out.println("使用引用对象方法 的过滤结果");
        //使用类的对象方法
        //TestLambda testLambda = new TestLambda();
        //filter(heros, testLambda::testHero);

        HeroChecker checker = new HeroChecker(){
            @Override
            public boolean test(Hero h){
                return (h.hp>100&&h.damage<50);
            }
        };
        System.out.println("使用匿名类过滤");               
        filter(heros, checker);
        System.out.println("使用Lambda表达式");
        filter(heros, h->h.hp>100&&h.damage<50);
        System.out.println("在Lambda表达式中使用静态方法");         
        filter(heros, h->TestLambda.testHero(h));
        System.out.println("直接引用和静态方法");
        filter(heros, TestLambda::testHero);
    }

    private static void filter(List<Hero> heros, HeroChecker checker){          //静态方法过滤器
        for(Hero hero : heros){
            if(checker.test(hero))
                System.out.println(hero);
        }
    }

    //引用静态方法
    public static boolean testHero(Hero h){                 //静态方法可以再lambda表达式中直接调用
    //public boolean testHero(Hero h){
        return h.hp>100&&h.damage<50;
    }
}