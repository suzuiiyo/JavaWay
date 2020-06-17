package collection;

import java.util.LinkedList;

public class MyStack2<T>{
    LinkedList<T> heros = new LinkedList<T>();
    //Stack<Hero> heros = new Stack<Hero>();
    //�����ʱ��,����synchronized��ͬ�������ǵ�ǰʵ��
    public synchronized void push(T h){
        while(heros.size()>=200){
            try{
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notifyAll();     //������������ʱ��,��������
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
        this.notifyAll();        //��������
        return heros.removeLast();
    }

    //�鿴û��Ҫ����synchronized����Ϊ���޸�����
    public T peek(){
        return heros.getLast();
    }

    public int size(){
        return heros.size();
    }
}