package lambda;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import charactor.Hero;

public class TestStream2 {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for(int i=0; i<10; i++){
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("集合初始化之后: ");
        System.out.println(heros);
        System.out.println("\n\t **********************\n");

        /*Collections.sort(heros);
        System.out.println(heros);
        System.out.println("Colloctions的sort方法筛选: " + heros.get(7));*/
        System.out.println("\n\t **********************\n");
        //lambda表达式根据hp升序排序
        /*filter(heros, Hero::matched);
        System.out.println(heros);
        System.out.println("lambda表达式筛选：" + heros.get(7));*/
        System.out.println("\n\t **********************\n");
        //使用聚合操作根据hp排序
        System.out.println(heros);
        String name = heros.stream().sorted((h1,h2)->h1.hp>h2.hp?-1:1).skip(2).map(h->h.getName()).findFirst().get();       //聚合操作返回一个String
        System.out.println("聚合操作筛选hp第三高的英雄名称是: " + name);                                                       //.map根据条件转换成流
    }

    private static void filter(List<Hero> heros, HeroChecker hChecker){      //过滤器接受匿名类
        for(Hero h : heros){
            if(hChecker.test(h));
                //System.out.println(h);
        }
    }
}