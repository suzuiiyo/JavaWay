package property;

public class Armor extends Item{
    int ac = 0;    //Armor Class
    
    public static void main(String[] args){
        Armor kai = new Armor();
        kai.name = "银鳞胸甲";
        kai.price = 100;
        kai.ac = 4;

        Armor jia = new Armor();
        jia.name = "强袭胸甲";
        jia.price = 400;
        jia.ac = 5;

        System.out.println("出售"+kai.name+";价格" +kai.price +";护甲等级" + kai.ac);
        System.out.println("出售"+jia.name+";价格" +jia.price +";护甲等级" + jia.ac);
    }
}