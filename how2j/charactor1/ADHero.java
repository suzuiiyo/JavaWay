package charactor1;
import charactor.Hero;

public class ADHero extends Hero implements AD{
    
    public void physicAttack(){
        System.out.println(this.name + "发起了普攻！");
    }

    public void physicAttack(Hero hero){
        String extName = hero.getName();
        System.out.println(this.name + "对" + extName +"发起了普攻！");
    }

    public void physicAttack(Hero hero, float hp){
        String extName = hero.getName();
        System.out.println(this.name + "对" + extName + "造成了" + hp + "点物理伤害");
    }
    
    public static void main(String[] args){
        ADHero bh = new ADHero();
        bh.name = "赏金猎人";

        Hero h1 = new Hero();
        h1.setName("沉默术士");
        Hero h2 = new Hero();
        h2.setName("痛苦女王");

        bh.physicAttack();
        bh.physicAttack(h1);
        bh.physicAttack(h1, 345);
        bh.attack(h1, h2);
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
            System.out.println(name + "攻击了" + heros[i].getName());
        }
    }
}