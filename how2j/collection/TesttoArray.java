package collection;

import java.util.ArrayList;

import charactor.Hero;

public class TesttoArray {
    public static void main(String[] args){
        ArrayList heros = new ArrayList();

        //初始化5个对象
        for(int i=0; i<5; i++){
            heros.add(new Hero("hero" + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);
        System.out.println(heros);
        Hero hs[] = (Hero[])heros.toArray(new Hero[]{});   //给toArray传递一个指定类型的对象才能转换成对应类型的数组,否则只能转换成Objetc数组
        System.out.println("数组: " + hs);
    }
}
    