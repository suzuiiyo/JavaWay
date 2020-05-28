package collection;

import java.util.HashMap;

import charactor.Hero;

public class TestHaspMap2 {
    public static void main(String[] args) {
        HashMap<String, Hero> heroMap = new HashMap<String, Hero>();

        heroMap.put("gareen", new Hero("gareen1"));
        System.out.println(heroMap);

        heroMap.put("gareen", new Hero("gareen2"));
        System.out.println(heroMap);

        heroMap.clear();
        Hero gareen = new Hero("gareen");


        heroMap.put("hero1", gareen);
        heroMap.put("hero2", gareen);
        System.out.println(heroMap);
    }
}