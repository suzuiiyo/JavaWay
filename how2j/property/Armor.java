package property;

public class Armor extends Item{
    int ac = 0;    //Armor Class
    
    public static void main(String[] args){
        Armor kai = new Armor();
        kai.name = "�����ؼ�";
        kai.price = 100;
        kai.ac = 4;

        Armor jia = new Armor();
        jia.name = "ǿϮ�ؼ�";
        jia.price = 400;
        jia.ac = 5;

        System.out.println("����"+kai.name+";�۸�" +kai.price +";���׵ȼ�" + kai.ac);
        System.out.println("����"+jia.name+";�۸�" +jia.price +";���׵ȼ�" + jia.ac);
    }
}