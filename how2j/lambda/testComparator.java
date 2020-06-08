package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import charactor.Hero;
import java.util.Collections;

public class testComparator {
    public static void main(String[] args) {
        List<Hero> herolist = new ArrayList<>();
        Random r = new Random();
        for(int i=0; i<10; i++){
            herolist.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合: ");
        System.out.println(herolist);
        System.out.println("使用静态方法得过滤结果: ");
        Collections.sort(herolist, (h1, h2)->testComparator.compare(h1, h2));    //按照hp升序排序
        System.out.println(herolist);
        System.out.println("使用容器中对象方法得到的过滤结果: ");
        Collections.sort(herolist, Hero::compareTo);   //按照damage升序排序
        System.out.println(herolist);
    }

    public static int compare(Hero h1, Hero h2){
        return h1.hp>=h2.hp?1:-1;                           //比较器方法
    }
}