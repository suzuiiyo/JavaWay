package charactor;
import property.Item;
import property.LifePotion;
import property.MagicPotion;

public class NTR extends Hero8{
    String skill;
    float armor;

    public NTR(){
        System.out.println("这是一个牛头人英雄");
    }

    public String getName(){
        return super.name;
    }
    public float getHP(){
        return super.hp;
    }

    public void useItem(Item i){
        System.out.println("使用了" + i.name);
        super.useItem(i);
    }

    public static void main(String[] args){
        //new NTR();
        NTR earthshaker = new NTR();
        Hero8 taurenchief = new Hero8();
        earthshaker.setName("撼地神牛");
        //taurenchief.setName("牛酋");
        earthshaker.setHP(134);
        taurenchief.setHP(364);
        System.out.println(earthshaker.getName() + "的名字是" + earthshaker.getName());
        System.out.println(taurenchief.getName() + "的血量是" + taurenchief.getHP());

        Item paper = new Item();
        Item RedBottle = new LifePotion();
        Item blueBottle = new MagicPotion();
        paper.name = "厕纸";
        earthshaker.useItem(paper);
        RedBottle.name = "红瓶";
        earthshaker.useItem(RedBottle);
        blueBottle.name = "蓝瓶";
        earthshaker.useItem(blueBottle);
    }
}