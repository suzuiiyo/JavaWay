package collection;

import java.util.ArrayList;

import charactor.Hero;
import property.Item;

public class GenericArrayList extends ArrayList {
    public boolean add(Object o){
        if((o instanceof Hero) || (o instanceof Item)){
            //�ж��Ƿ���hero����item����
            super.add(o);     //Ϊ��͵��õ��ø����add����
            return true;
        }else{
            throw new IllegalArgumentException();
            //����������׳����Ϸ������쳣
        }
    }

    public void add(int pos, Object o){
        if((o instanceof Hero) && (o instanceof Item)){
            super.add(pos, o);
        }else {
            throw new IllegalAccessError();
        }
    }

    public void addAll(GenericArrayList a){
        super.addAll(a);
    }

    public void addAll(int pos, GenericArrayList a){
        super.add(pos, a);
    }

    public static void main(String[] args){
        GenericArrayList ga = new GenericArrayList();
        Hero h = new Hero("����");
        ga.add(h);
        System.out.println(ga);
        Item i = new Item("");
        ga.add(i);
        System.out.println(ga);
        String str = "";
        ga.add(str);
    }
}