package property;

public class Item{
    public String name;
    int price;

    public void effect(){
        System.out.println("ʹ����Ʒ");
    }

    public String toString(){
        return (name + price);
    }

    public void finalize(){
        System.out.println("��ǰ�������ڱ�����");
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
        one.name = "��ƿ";
        one.price = 50;

        Item two = new Item();
        two.name = "��ƿ";
        two.price = 50;

        Item three = new Item();
        three.name = "����";
        three.price = 350;
        System.out.println("what's up");

        System.out.println(one.equals(two));
        System.out.println(one.equals(three));
    }
}