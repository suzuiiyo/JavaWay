package collection;

import java.util.ArrayList;
import java.util.List;

import charactor.Hero;

public class TestCollection {
    public static void main(String[] args){
        //数组的局限性
        //Hero heros[] = new Hero[10];
        //声明长度是10的数组
        //不用的数组就浪费了
        //超过10的个数，又放不下
        //heros[0] = new Hero("兽王", 356);
        //heros[20] = new Hero("巫医");

        //容器类ArrayList heros = new ArrayList();
        ArrayList heros = new ArrayList();
        heros.add(new Hero("兽王"));
        System.out.println(heros.size());
        System.out.println(heros);          //此处因为重写了Hero类的toString返回name，否则返回哈希

        heros.add(new Hero("巫医"));
        System.out.println(heros.size());
        System.out.println(heros);

        List<Hero> heros2 = new ArrayList<>();
        //放进容器
        for(int i=0; i<5; i++){
            heros2.add(new Hero("hero" + i));
            System.out.println(heros2);
        }
    }
}