package charactor1;
import charactor.Hero;
import charactor.Mortal;

public class ADAPHero extends Hero implements AD, AP, Mortal {

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
    public void die(){
        System.out.println("凡人皆需服侍");
    }
    public void die(Hero hero){
        String extName = hero.getName();
        System.out.println(extName + ",凡人皆需服侍," + this.name);
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

        QOP.die(AM);
    }
}