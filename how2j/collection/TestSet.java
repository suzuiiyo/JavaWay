package collection;

import java.util.ArrayList;

import charactor.Hero;

public class TestSet {
    public static void main(String[] args){
        ArrayList heros = new ArrayList();

        //初始化5个对象
        for(int i=0; i<5; i++){
            heros.add(new Hero("hero" + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);

        System.out.println(heros);
        System.out.println("把下标是5的元素,替换为\"hero 5\"");
        heros.set(5, new Hero("hero5"));
        System.out.println(heros);
    }
}