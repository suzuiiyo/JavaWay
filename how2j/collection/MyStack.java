package collection;

import java.util.LinkedList;
import charactor.Hero;

public class MyStack<T> implements Stack<T> {
    LinkedList<Hero> heros = new LinkedList<Hero>();
    //Stack<Hero> heros = new Stack<Hero>();
    //插入的时候,加上synchronized，同步对象是当前实例
    public synchronized void push(Hero h){
        try{
            this.wait();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        heros.addLast(h);
    }

    public synchronized Hero pull() {
        try{
            this.wait();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return heros.removeLast();
    }

    //查看没必要加上synchronized，因为不修改数据
    public Hero peek(){
        return heros.getLast();
    }

    public int size(){
        return heros.size();
    }
}