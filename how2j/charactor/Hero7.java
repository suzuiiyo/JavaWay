package charactor;

import property.LifePotion;
import property.MagicPotion;

public class Hero7 extends Hero {
    public String name;
    protected float hp;

    public void useLifePotin(LifePotion lp){
        lp.effect();
    }
    public void useMagicPotin(MagicPotion mp){
        mp.effect();
    }

    public static void main(String[] args){
        LifePotion lp = new LifePotion();
        MagicPotion mp = new MagicPotion();

        Hero7 warlock = new Hero7();
        warlock.setName(" ı ø");

        warlock.useLifePotin(lp);
        warlock.useMagicPotin(mp);
    }
}