package charactor;
import property.Item;
import property.LifePotion;
import property.MagicPotion;

public class NTR extends Hero8{
    String skill;
    float armor;

    public NTR(){
        System.out.println("����һ��ţͷ��Ӣ��");
    }

    public String getName(){
        return super.name;
    }
    public float getHP(){
        return super.hp;
    }

    public void useItem(Item i){
        System.out.println("ʹ����" + i.name);
        super.useItem(i);
    }

    public static void main(String[] args){
        //new NTR();
        NTR earthshaker = new NTR();
        Hero8 taurenchief = new Hero8();
        earthshaker.setName("������ţ");
        //taurenchief.setName("ţ��");
        earthshaker.setHP(134);
        taurenchief.setHP(364);
        System.out.println(earthshaker.getName() + "��������" + earthshaker.getName());
        System.out.println(taurenchief.getName() + "��Ѫ����" + taurenchief.getHP());

        Item paper = new Item();
        Item RedBottle = new LifePotion();
        Item blueBottle = new MagicPotion();
        paper.name = "��ֽ";
        earthshaker.useItem(paper);
        RedBottle.name = "��ƿ";
        earthshaker.useItem(RedBottle);
        blueBottle.name = "��ƿ";
        earthshaker.useItem(blueBottle);
    }
}