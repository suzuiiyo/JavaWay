package generic;

import java.util.ArrayList;
import java.util.List;

import charactor.Hero;
import charactor1.ADHero;
import charactor1.APHero;

public class ViewGeneric {
    public static void main(String[] args) {
        List<? extends Hero> extlist = new ArrayList<>();
        for(int i=0; i<extlist.size(); i++){
            System.out.println(extlist.get(i));
        }

        ArrayList<Hero> hs = new ArrayList<>();
        ArrayList<APHero> aphs = new ArrayList<>();
        ArrayList<ADHero> adhs = new ArrayList<>();
        

        iterate(hs);
        iterate(aphs);
        iterate(adhs);
    }

    public static void iterate(ArrayList<? extends Hero> list){
        for(Hero hero : list){
            System.out.println(hero.name);
        }
    }

    /*public static void iterate(ArrayList<Hero> list){
        for(Hero hero : list){
            System.out.println(hero.name);
        }
    }*/

    public static void iterateAP(ArrayList<APHero> list){
        for(APHero hero : list){
            System.out.println(hero.name);
        }
    }

    public static void iterateAD(ArrayList<ADHero> list){
        for(ADHero hero : list){
            System.out.println(hero.name);
        }
    }
}