package collection;

import java.util.LinkedList;

public class MyStack2<T>{
    LinkedList<T> heros = new LinkedList<T>();
    //Stack<Hero> heros = new Stack<Hero>();
    //插入的时候,加上synchronized，同步对象是当前实例
    public synchronized void push(T h){
        while(heros.size()>=200){
            try{
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notifyAll();     //不满足条件的时候,提醒所有
        heros.addLast(h);
    }

    public synchronized T pull() {
        while(heros.isEmpty()){
            try{
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notifyAll();        //提醒所有
        return heros.removeLast();
    }

    //查看没必要加上synchronized，因为不修改数据
    public T peek(){
        return heros.getLast();
    }

    public int size(){
        return heros.size();
    }
}