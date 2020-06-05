package generic;

import java.util.LinkedList;

import charactor.Hero;
import property.Item;

public class MyStackGeneric<T> {
    public static void main(String[] args) {
        //在声明这个Stack的时候，使用泛型《Hero>就表示该Stack只能放Hero
        LinkedList<Hero> herostack = new LinkedList<>();
        herostack.push(new Hero("兽王"));
        //herostack.push(new Item("血瓶"));
        System.out.println(herostack);
        LinkedList<Item> itemstack = new LinkedList<>();
        itemstack.push(new Item("魔瓶"));
        //itemstack.push(new Hero("兽王"));
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