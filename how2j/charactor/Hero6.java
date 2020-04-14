package charactor;

import property.Item;
import property.LifePotion;
import property.MagicPotion;

public class Hero6 {
    public String name;
    protected float hp;

    public void useItem(Item i){
        i.effect();
    }

    public static void main(String[] args){
        Hero6 garen = new Hero6();
        garen.name = "����";

        LifePotion lp = new LifePotion();
        MagicPotion mp = new MagicPotion();

        garen.useItem(lp);
        garen.useItem(mp);
    }
}