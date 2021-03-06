package property;

public class Item implements Comparable<Item> {
    public String name;
    int price;
    public Item(){
    }

    public Item(String str){
        this.name = str;
    }
    public Item(String str, int price){
        this.name = str;
        this.price = price;
    }

    public void effect(){
        System.out.println("使用物品");
    }

    public String toString(){
        return String.valueOf("[name:" + name + " " + "item.price: " + price + "]");
    }

    public void finalize(){
        System.out.println("当前对象正在被回收");
    }

    public boolean equals(Object o){
        if(o instanceof Item){
            Item h = (Item) o;
            return this.price == h.price;
        }
        return false;
    }

    public static void main(String[] args){
        Item one = new Item();
        one.name = "红瓶";
        one.price = 50;

        Item two = new Item();
        two.name = "蓝瓶";
        two.price = 50;

        Item three = new Item();
        three.name = "卷轴";
        three.price = 350;
        System.out.println("what's up");

        System.out.println(one.equals(two));
        System.out.println(one.equals(three));
    }

    public int compareTo(Item anoItem) {
        return anoItem.price - price;
    }
}