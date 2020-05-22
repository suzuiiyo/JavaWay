package collection;

import java.util.ArrayList;

import charactor.Hero;

public class TestContain {
    public static void main(String[] args){
        ArrayList heros = new ArrayList<>();

        //初始化5个对象
        for(int i=0; i<5; i++){
            heros.add(new Hero("hero" + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);

        System.out.println(heros);
        //判断一个对象是否在容器中
        //判断标准:是否是同一个对象,而不是name是否相同
        System.out.println("虽然一个新对象名字也叫hero1，但是contains的返回是：");
        System.out.println(heros.contains(new Hero("hero1")));
        System.out.println("而对specialHero的判断， contains的返回时: ");
        System.out.println(heros.contains(specialHero));
    }
}