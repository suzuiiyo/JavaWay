package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import charactor.Hero;

public class TestLambdaHero {
    public static void main(String[] args) {
        List<Hero> herolist = new ArrayList<>();
        Random r = new Random();
        for(int i=0; i<10; i++){
            herolist.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合: ");
        System.out.println(herolist);
        System.out.println("\n\t****************************\n");

        Collections.sort(herolist, (h1, h2)->h1.hp>h2.hp?1:-1);                 //比较器也是一种过滤器,筛选满足条件的对象
        System.out.println(herolist);
    }
}