package collection;

import java.util.LinkedList;

import charactor.Hero;

public class MyStack implements Stack {
    LinkedList<Hero> heros = new LinkedList<Hero>();
    //�����ʱ��,����synchronized��ͬ�������ǵ�ǰʵ��
    public synchronized void push(Hero h){
        heros.addLast(h);
    }

    public synchronized Hero pull(){
        return heros.removeLast();
    }

    //�鿴û��Ҫ����synchronized����Ϊ���޸�����
    public Hero peek(){
        return heros.getLast();
    }
}