package generic;

import java.util.ArrayList;

import charactor.Hero;
import charactor1.APHero;

public class TestExtendsGeneric {
    public static void main(String[] args) {
        ArrayList<APHero> apHeroList = new ArrayList<APHero>();
        apHeroList.add(new APHero());

        ArrayList<? extends Hero> heroList = apHeroList;
        //? extend Hero表示这是一个Hero泛型的子类泛型
        //heroList 的泛型可以是Hero
        //heroList 的泛型可以是APHero
        //heroList 的泛型可以是ADHero

        //可以确凿的事，从heroList取出来的对象，一定事可以转型城Hero的
        Hero h= heroList.get(0);
        //但是，不能往里面放东西
        //heroList.add(new ADHero());   //编译错误. 即便是Hero类也不能往里面放
    }
}