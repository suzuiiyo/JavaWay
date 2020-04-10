
public class Item2 {
    String name;
    float price;

    private Item2(){}

    private static Item2 instance;

    public static Item2 getInstance(){
        if(null == instance){
            instance = new Item2();
        }
        return instance;
    }

    public static void main(String[] args){
        Item2 BKB = Item2.getInstance();
        BKB.name = "Black King Bar";
        BKB.price = 3750;
        System.out.println("The item's name is " + BKB.name + " and its price's " + BKB.price);
    }
}