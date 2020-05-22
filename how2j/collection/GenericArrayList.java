package collection;

import java.util.ArrayList;

import charactor.Hero;
import property.Item;

public class GenericArrayList extends ArrayList {
    public boolean add(Object o){
        if((o instanceof Hero) || (o instanceof Item)){
            //判断是否是hero或者item对象
            super.add(o);     //为真就调用调用父类的add方法
            return true;
        }else{
            throw new IllegalArgumentException();
            //如果不是则抛出不合法参数异常
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
        Hero h = new Hero("兽王");
        ga.add(h);
        System.out.println(ga);
        Item i = new Item("");
        ga.add(i);
        System.out.println(ga);
        String str = "";
        ga.add(str);
    }
}