package generic;

import java.util.ArrayList;

import charactor.Hero;
import charactor1.ADHero;
import charactor1.APHero;

public class TestSuperGeneric {
    public static void main(String[] args) {
        ArrayList<? super Hero> heroList = new ArrayList<>();
        //? super Hero表示herolist的泛型是Hero或者其父类泛型
        //heroList的泛型可以是Hero
        //heroList的泛型可以是Object

        //所以姐可以插入Hero
        heroList.add(new Hero());
        //也可以插入Hero的子类
        heroList.add(new ADHero());
        heroList.add(new APHero());

        //但是，不能从里面取数据出来,因为其泛型可能事Object，而Object强转Hero会失败
        //Hero h = heroList.get(0);

    }
}