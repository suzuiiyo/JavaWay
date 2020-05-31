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
        System.out.println("����Ϊhero-5555��Hero�ܹ���: " + hero55.size() + "��");
        long t2 = System.currentTimeMillis();
        System.out.println("ѭ��������ʱ: "+ (t2 - t1));

        System.out.println("**********************");

        /*HashMap<Hero, String> heroMap = new HashMap<Hero, String>();
        for(Hero h : heroList){
            heroMap.put(h, h.getName());
        }
        int count=0;
        for(Map.Entry<Hero, String> entry : heroMap.entrySet()){     //����hashmap�ļ�ֵ��
            if(entry.getValue().equals("hero-5555")){
                count++;
            }
        }*/
        HashMap<String, List<Hero>> heroMap = new HashMap<>();  //value��list����Ŷ��Hero���󣬷���Ḳ��ֻ�����һ��Hero
        for(Hero h : heroList){
            List<Hero> listDes = heroMap.get(h.name);
            if(listDes==null){                           //h.nameΪ��get����null
                listDes = new ArrayList<>();            //����һ��Ӣ������Ӣ��List�ļ�ֵ��,����Ψһ,Ӣ�۶�������кܶ�ɣ�ȫ���Ž�list� ÿһ�������ֽ���һ���µ�����
                heroMap.put(h.name, listDes);           //��listDes�Ž�haspMap
            }
            listDes.add(h);                         //listDes�仯ʱ,hashMap����ű仯?
        }
        long t3 = System.currentTimeMillis();
        List<Hero> hero555 = heroMap.get("hero-5555");      //ȡ��herMap��hero-5555��ֵ��Ӧ��ֵ
        long t4 = System.currentTimeMillis();
        System.out.println(hero555);
        System.out.println("����Ϊhero-5555��Hero�����ܹ���: " + hero555.size() + "��");
        System.out.println("hashMap��ʱ: " + (t4 - t3));

        System.out.println(heroMap);
    }
}