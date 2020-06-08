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
        System.out.println("初始化后的集合: ");
        System.out.println(herolist);
        System.out.println("使用引用对象方法的过滤结果: ");             //创建对象调用非静态方法
        TestLambda3 heroLambda3 = new TestLambda3();
        filter(herolist, heroLambda3::testHero);

        System.out.println("Lambda表达式中调用容器中的对象的matched方法：");            //lambda表达式调用容器对象自身的方法
        filter(herolist, h->h.matched());

        System.out.println("引用容器中对象的方法 的过滤结果: ");     //matched方法恰好是容器对象Hero的方法
        filter(herolist, Hero::matched);

    }

    private static void filter(List<Hero> herolist, HeroChecker checker){
        for(Hero h : herolist){
            if(checker.test(h))
                System.out.println(h);
        }
    }
    
    public boolean testHero(Hero h){            //非静态方法,先创建对象在调用
        return h.hp>100&&h.damage<50;           //过滤条件剥离出来,其实是为了进一步简化lambda表达式
    }
}