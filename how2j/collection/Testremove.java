package collection;

import java.util.ArrayList;
import java.util.List;

import charactor.Hero;

public class Testremove {
    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero " + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(3, specialHero);
        System.out.println(heros);
        heros.remove(specialHero);
        System.out.println(heros);
    }
}