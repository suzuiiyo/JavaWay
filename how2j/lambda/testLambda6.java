package lambda;
import java.util.List;
import java.util.ArrayList;
import charactor.Hero;

import java.util.Random;

public class testLambda6 {
    public static void main(String[] args) {
        Random r= new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for(int i=0; i<5; i++){
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合: ");
        System.out.println(heros);
        System.out.println("过滤条件: hp>100 && damage<50");
        System.out.println("通过for遍历操作方式找出满足条件的数据: ");

        for(Hero h : heros){
            if(h.hp > 100 && h.damage <50)
                System.out.println(h.name);
        }

        System.out.println("通过聚合操作方式找出来满足条件的数据: ");
        heros
            .stream()
            .filter(h -> h.hp > 100 && h.damage<50)
            .forEach(h -> System.out.println(h.name));
    }
}