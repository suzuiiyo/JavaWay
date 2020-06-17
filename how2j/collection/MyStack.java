package collection;

import java.util.LinkedList;
import charactor.Hero;

public class MyStack<T> implements Stack<T> {
    LinkedList<Hero> heros = new LinkedList<Hero>();
    //Stack<Hero> heros = new Stack<Hero>();
    //�����ʱ��,����synchronized��ͬ�������ǵ�ǰʵ��
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

    //�鿴û��Ҫ����synchronized����Ϊ���޸�����
    public Hero peek(){
        return heros.getLast();
    }

    public int size(){
        return heros.size();
    }
}