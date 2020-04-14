package property;

public class Item{
    String name;
    int price;

    public void effect(){
        System.out.println("使用物品");
    }

    public static void main(String[] args){
        Item one = new Item();
        one.name = "????";
        one.price = 50;

        Item two = new Item();
        two.name = "????";
        two.price = 300;

        Item three = new Item();
        three.name = "?¤??";
        three.price = 350;
        System.out.println("what's up");
    }
}