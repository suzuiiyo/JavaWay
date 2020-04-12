package charactor1;
import charactor.Hero;

public class ADAPHero extends Hero implements AD, AP {

    public void magicAttack(){
        System.out.println(this.name + "使用技能");
    }
    public void magicAttack(Hero hero, float hp){
        String extName = hero.getName();
        System.out.println(this.name + "使用技能对" + extName + "造成了" + hp + "点伤害");
    }
    
    public void physicAttack(){
        System.out.println(this.name + "发起攻击");
    }
    public void physicAttack(Hero hero, float hp){
        String extName = hero.getName();
        System.out.println(this.name + "发起普攻对" + extName + "造成了" + hp + "点伤害");
    }

    public static void main(String[] args){
        ADAPHero QOP = new ADAPHero();
        QOP.setName("痛苦女王");
        Hero AM = new Hero();
        AM.setName("敌法师");

        QOP.physicAttack();
        QOP.physicAttack(AM, 134);
        QOP.magicAttack();
        QOP.magicAttack(AM, 342);
    }
}