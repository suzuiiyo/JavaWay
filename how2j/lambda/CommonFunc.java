package lambda;

import java.util.ArrayList;

import charactor.Hero;

public class CommonFunc {
    public static void main(String[] args) {
        ArrayList<Hero> herolist = new ArrayList<>();
        ArrayList<Hero> herolistback = new ArrayList<>();
        for(int i=0; i<40; i++){
            herolist.add(new Hero("hero" + i, (float)Math.random()*1000, (float)Math.random()*1000));
        }
        for(Hero h : herolist){
            if(h.hp>100 && h.damage<50){
                herolistback.add(h);
            }
        }
        System.out.println("���е�Ӣ��:\n" + herolist);
        System.out.println("ɸѡ������Ӣ��:\n" + herolistback);
    }
}