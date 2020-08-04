package charactor1;
import charactor.Hero;
import charactor.Mortal;

public class APHero extends Hero implements AP, Mortal{
    public APHero(){};

    public APHero(String name){
        this.name = name;
    }
    public void magicAttack(){
        System.out.println(this.name + "发起了法术！");
    }

    public void magicAttack(Hero hero){
        String extName = hero.getName();
        System.out.println(this.name + "对" + extName +"发起了法术！");
    }

    public void magicAttack(Hero hero, float hp){
        String extName = hero.getName();
        System.out.println(this.name + "对" + extName + "造成了" + hp + "点魔法伤害");
    }
    
    public void die(){
        System.out.println("凡人终有一死");
    }
    public void die(Hero hero){
        String extName = hero.getName();
        System.out.println(extName + ",凡人终有一死");
    }
    public static void main(String[] args){
        APHero bm = new APHero();
        bm.name = "兽王";

        Hero h1 = new Hero();
        h1.setName("魅惑魔女");
        Hero h2 = new Hero();
        h2.setName("秀逗魔法师");

        bm.magicAttack();
        bm.magicAttack(h1);
        bm.magicAttack(h1, 345);
        bm.attack(h1, h2);

        bm.die(h2);
    }
    /* public void attack(){
        System.out.println(name + "进行了一次攻击，但是不确定打中了谁");
    }
    public void attack(Hero h1){
        System.out.println(name + "对" + h1.name + "进行了一次攻击");
    }
    public void attack(Hero h1, Hero h2){
        System.out.println(name + "同时对" + h1.name + "和" +h2.name + "进行了攻击");
    }
    */
    public void attack(Hero... heros){
        for(int i=0; i<heros.length; i++){
            float hurt = (float)Math.random()*100;    
            System.out.println(name + "攻击了" + heros[i].getName() + ",造成了" +hurt +"点魔法伤害");
        }
    }

    /*public String getClassName(){
        String className=null;
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] element=e.getStackTrace();
            className=element[0].getClassName();
        }
        return className;
    }*/
}