package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import charactor.Hero;
import charactor1.ADHero;
import charactor1.APHero;
import charactor1.Support;

public class reverseHashMap {
    public static void main(String[] args) {
        List<Hero> herolist = new ArrayList<>();
        for(int i=0; i<100; i++){
            if(i%2==1&i%3!=0){
                Hero adhero = new ADHero("ADHero" + i);
                herolist.add(adhero);
            }
            else if(i%2==1&&i%3==0){
                    Hero aphero = new APHero("APHero" + i);
                    herolist.add(aphero);
            }else{
                Hero tank = new Support("Tank" + i);
                herolist.add(tank);
            }
        }
        System.out.println(herolist);
        System.out.println("\n\n\t *************** \n");

        HashMap<String, List<Hero>> heroMap = new HashMap<>();
        for(Hero h : herolist){
            List<Hero> listDes = heroMap.get(h.getClassName());    //����ط���keyӦ�ø�if�����keyһ��
            if(listDes == null){
                listDes = new ArrayList<>();
                heroMap.put(h.getClassName(), listDes);         //����ط���keyӦ�ø������һ��,����listDesֻ�ᱣ�����һ��add��ֵ
            }
            listDes.add(h);
        }
        //System.out.println(heroMap);
        //System.out.println(heroMap.keySet());
        //System.out.println(heroMap.values());
        HashMap<List<Hero>, String> heroMapRev = new HashMap<>();
        for(Map.Entry<String, List<Hero>> entry : heroMap.entrySet()){
            String name = heroMapRev.get(entry.)
            
        }
    }
}