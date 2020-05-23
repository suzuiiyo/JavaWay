package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import charactor.Hero;

public class TestIterator {
    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<Hero>();
        //放5个Hero进入容器
        for(int i=0; i<5; i++){
            heros.add(new Hero("hero" + i));
        }
        //第二种遍历，使用迭代器
        System.out.println("---------使用while的iterator---------");
        Iterator<Hero> it = heros.iterator();
        while(it.hasNext()){
            Hero h = it.next();
            System.out.println(h);
        }
        //迭代器的for写法
        System.out.println("---------使用for的iterator-----------");
        for(Iterator<Hero> iterator = heros.iterator(); iterator.hasNext();){
            Hero hero = (Hero) iterator.next();
            System.out.println(hero);
        }
    }
}