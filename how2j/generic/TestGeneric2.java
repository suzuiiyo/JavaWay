package generic;

import java.util.ArrayList;
import java.util.List;

import charactor.Hero;
import charactor1.APHero;
import property.Item;

public class TestGeneric2 {
    public static void main(String[] args){
        //对于不适用泛型的容器,可以往里面放英雄，也可以往里面放物品
        List heros = new ArrayList();

        heros.add(new Hero("兽王"));

        //本来用域存放英雄的容器,现在也可以存放物品了
        heros.add(new Item("血瓶"));

        //对象转型会出现问题
        Hero h1 = (Hero) heros.get(0);
        //尤其是在容器里放的对象太多的时候,就记不清楚哪个位置放的是哪种类型的对象了
        //不能转为Hero  只能转成Item
        Item h2 = (Item) heros.get(1);

        //引入泛型Generic
        //声明容器的时候，就指定了这种容器，只能放Hero,放其他的就会报错
        List<Hero> genericheros = new ArrayList<Hero>();
        genericheros.add(new Hero("提莫"));
        //如果不是Herole类型，根本就放不进其
        //genericheros.add(new Item("血瓶"));

        //除此之外，还能存放Hero的子类
        genericheros.add(new APHero());

        //并且再取出数据的时候，不需要再进行转型了，因为里面肯定是放的Hero或者其子类
        Hero h = genericheros.get(0);
        System.out.println(h);

        for( Object b : heros){
            System.out.println(b);
        }
    }
}