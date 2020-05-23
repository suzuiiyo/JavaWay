package digit;

import java.util.ArrayList;

import charactor.Hero;
import collection.GenericArrayList;
import property.Item;

public class GenericArrayList2 extends ArrayList {
    public boolean add(Object o){
        if((o instanceof Hero) || (o instanceof Item)){
            super.add(o);
            return true;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public void add(int pos, Object o){
        if((o instanceof Hero) || (o instanceof Item)){
            super.add(pos, o);
        }else{
            throw new IllegalArgumentException();
        }
    }

    public void addAll(GenericArrayList2 a){
            super.addAll(a);
        }

    public void addAll(int pos, GenericArrayList2 a){
            super.add(pos, a);
    }

    public static void main(String[] args) {
        GenericArrayList ga = new GenericArrayList();
        Hero h = new Hero("ÊÞÍõ");
        ga.add(h);
        System.out.println(ga);
        Item i = new Item("");
        ga.add(i);
        System.out.println(ga);
        String str = "";
        ga.add(str);
    }
}