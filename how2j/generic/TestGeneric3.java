package generic;

import java.util.ArrayList;

import charactor.Hero;
import property.Item;

public class TestGeneric3 {
    public static void main(String[] args) {
        ArrayList heros = new ArrayList();
        for(int i=0; i<5; i++){
            heros.add(new Hero("hero" + i));
        }
        System.out.println(heros);

        for(int i=0; i<heros.size(); i++){
            System.out.println(heros.get(i));
            heros.set(i, new Item("Ѫƿ" + i));
        }
        System.out.println(heros);

        for(Object o : heros){
            System.out.println(o);
        }
    }
}