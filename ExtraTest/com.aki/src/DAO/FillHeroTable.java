package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import bean.Hero;

public class FillHeroTable {
    public List<Hero> genHeroList(){
        List<Hero> heros = new ArrayList<>();
        Random rand = new Random();
        char[] ch = new char[100];
        for(int i=0; i<100; i++){
            ch[i] = (char) (rand.nextInt(58) + 65);
            String str = String.valueOf(ch);
            Hero hero = new Hero();
            hero.setName(str.substring(i));
            hero.setHp((float)(Math.random()*300));
            hero.setAttack((float)(Math.random()*400));

            heros.add(hero);
        }
        return heros;
    }

    public static void main(String[] args) {
        HeroDAO hDao = new HeroDAO();
        List<Hero> heros = new FillHeroTable().genHeroList();
        for(int i=0; i<100; i++){
            hDao.add(heros.get(i));
            if(i==99)
                System.out.println("Ìí¼ÓÍê³É");
        }
    }
}
