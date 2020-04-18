package charactor;
import property.Item;
import property.LifePotion;
import property.MagicPotion;

public class Hero8 {
    protected String name = "裂魂人";
    protected float hp;
    protected float moveSpeed;

    //public Hero8(){
      //  System.out.println("Hero8的构造方法");
    //}
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    public void setHP(float hp){
        this.hp = hp;
    }
    public float getHP(){
        return this.hp;
    }
    
    public void useItem(Item i){
        i.effect();
    }

    /*public void setFHP(float hp){
        this.hp = hp;
    }
    public float getFHP(){
        return this.hp;
    }*/

    public static void main(String[] args){
        Hero8 SpiritBreaker = new Hero8();
        Item paper = new Item();
        LifePotion RedBottle = new LifePotion();
        MagicPotion BlueBottle = new MagicPotion();
        SpiritBreaker.useItem(paper);
        SpiritBreaker.useItem(RedBottle);
        SpiritBreaker.useItem(BlueBottle);
    }
}