package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import charactor.Hero;
import property.Item;

public class TestComparetor {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        List<Item> items = new ArrayList<Item>();

        for(int i=0; i<10; i++){
            //通过随机值实例化hero的hp和damage
            heros.add(new Hero("hero " + i, r.nextInt(100), r.nextInt(100)));
            items.add(new Item("item" + i, (int)(Math.random()*100)));
        }
        System.out.println("初始化后的集合: ");
        System.out.println(heros);
        System.out.println("\n\t *****************\n");
        System.out.println(items);
        System.out.println("\n\t ***************************************\n");

        //直接调用sort会出现编译错误,因为Hero有各种属性
        //到底按照那种属性进行比较,Collections也不知道，不去顶，所以没法排
        //Collections.sort(heros);

        //引入Comparator，指定比较的算法
        /*Comparator<Hero> c = new Comparator<Hero>(){
            @Override
            public int compare(Hero h1, Hero h2){
                //按照hp进行排序
                if(h1.hp>=h2.hp)
                    return 1;          //正数表示h1比h2要大
                else
                    return -1;
            }
        };*/

        Collections.sort(heros);
        Collections.sort(items);
        System.out.println("按照伤害升序排序后的Hero集合: ");
        System.out.println(heros);
        System.out.println("\n\t *****************\n");
        System.out.println("按照价格降序排序后的Item集合: ");
        System.out.println(items);
    }
}