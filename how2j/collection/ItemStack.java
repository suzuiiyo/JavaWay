package collection;

import java.util.LinkedList;
import property.Item;

public class ItemStack {
    public static void main(String[] args) {
        ItemStack itemStack = new ItemStack();
        for(int i=0; i<5; i++){
            Item item = new Item("Item name " + i);
            System.out.println("Ñ¹ÈëItem: " + item);
            itemStack.push(item);
        }
        for(int i=0; i<5; i++){
            Item item= itemStack.pull();
            System.out.println("µ¯³ö Item" + item);
        }
    }

    LinkedList<Item> Items = new LinkedList<Item>();
    public void push(Item h){
        Items.addLast(h);
    }

    public Item pull(){
        return Items.removeLast();
    }

    public Item peek(){
        return Items.getLast();
    }
}