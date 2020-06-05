package generic;

import java.util.LinkedList;

import charactor.Hero;
import property.Item;

public class MyStackGeneric<T> {
    public static void main(String[] args) {
        //���������Stack��ʱ��ʹ�÷��͡�Hero>�ͱ�ʾ��Stackֻ�ܷ�Hero
        LinkedList<Hero> herostack = new LinkedList<>();
        herostack.push(new Hero("����"));
        //herostack.push(new Item("Ѫƿ"));
        System.out.println(herostack);
        LinkedList<Item> itemstack = new LinkedList<>();
        itemstack.push(new Item("ħƿ"));
        //itemstack.push(new Hero("����"));
        System.out.println(itemstack);
    }

    LinkedList<T> myStack = new LinkedList<>();
    public void push(T t){
        myStack.addLast(t);
    }

    public T pull(T t){
        return myStack.removeLast();
    }

    public T peek(T t){
        return myStack.getLast();
    }
}