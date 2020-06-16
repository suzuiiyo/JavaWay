package multithreading;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import charactor.Hero;
import collection.Stack;

public class SynchronizedMyStack implements Stack{
    LinkedList<Hero> list = new LinkedList<>();
    List<Hero> list2 = (List<Hero>)Collections.synchronizedList(list);

    public void push(Hero h){
        list2.add(h);
    }

    public Hero pull(){
       // return list2.removeLast();          //LinkedList的方法
        return list2.remove(list2.size()-1);
    }

    public Hero peek(){
       // return list2.getLast();                //LinkedList的方法
        return list2.get(list2.size()-1);
    }
}