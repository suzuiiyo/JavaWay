package collection;

import java.util.ArrayList;

import charactor.Hero;

public class TestSet {
    public static void main(String[] args){
        ArrayList heros = new ArrayList();

        //��ʼ��5������
        for(int i=0; i<5; i++){
            heros.add(new Hero("hero" + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);

        System.out.println(heros);
        System.out.println("���±���5��Ԫ��,�滻Ϊ\"hero 5\"");
        heros.set(5, new Hero("hero5"));
        System.out.println(heros);
    }
}