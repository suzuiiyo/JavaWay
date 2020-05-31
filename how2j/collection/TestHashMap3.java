package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import charactor.Hero;

public class TestHashMap3 {
    public static void main(String[] args) {
        List<Hero> heroList = new ArrayList<>();
        for(int i=0; i<30000; i++){
            int random = (int)(Math.random()*10000);
            heroList.add(new Hero("hero-" + random));
            heroList.get(i).hp += i;
        }

        List<Hero> hero55 = new ArrayList<>();
        long t1 = System.currentTimeMillis();
        for(Hero h : heroList){
            if(h.getName().equals("hero-5555")){
                hero55.add(h);
            }
        }
        System.out.println(hero55);
        System.out.println("名字为hero-5555的Hero总共有: " + hero55.size() + "个");
        long t2 = System.currentTimeMillis();
        System.out.println("循环遍历耗时: "+ (t2 - t1));

        System.out.println("**********************");

        /*HashMap<Hero, String> heroMap = new HashMap<Hero, String>();
        for(Hero h : heroList){
            heroMap.put(h, h.getName());
        }
        int count=0;
        for(Map.Entry<Hero, String> entry : heroMap.entrySet()){     //遍历hashmap的键值对
            if(entry.getValue().equals("hero-5555")){
                count++;
            }
        }*/
        HashMap<String, List<Hero>> heroMap = new HashMap<>();  //value是list，存放多个Hero对象，否则会覆盖只留最后一个Hero
        for(Hero h : heroList){
            List<Hero> listDes = heroMap.get(h.name);
            if(listDes==null){                           //h.name为空get的是null
                listDes = new ArrayList<>();            //建立一个英雄名：英雄List的键值对,名字唯一,英雄对象可能有很多可，全部放进list里， 每一个新名字建立一个新的链表
                heroMap.put(h.name, listDes);           //把listDes放进haspMap
            }
            listDes.add(h);                         //listDes变化时,hashMap会更着变化?
        }
        long t3 = System.currentTimeMillis();
        List<Hero> hero555 = heroMap.get("hero-5555");      //取出herMap里hero-5555键值对应的值
        long t4 = System.currentTimeMillis();
        System.out.println(hero555);
        System.out.println("名字为hero-5555的Hero对象总共有: " + hero555.size() + "个");
        System.out.println("hashMap耗时: " + (t4 - t3));

        System.out.println(heroMap);
    }
}