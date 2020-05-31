package charactor1;
import charactor.Hero;

public class Support extends Hero implements healer{
    public Support(){};
    public Support(String name){
        this.name = name;
    }
    public void heal(){
        System.out.println("救治"+ this.name+"!");
    }

    public void heal(Hero hero){
        hero.getName();
        System.out.println(this.name + "给英雄" + hero.getName()+ "治疗");
    }

    public void heal(Hero hero, int hp){
        //System.out.println(hero.hp);
        hero.getName();
        float HP = hero.getHp() + hp;
        System.out.println(this.name + "治疗" + hero.getName()+ ",为其恢复" + hp + "点生命," + "\n" +hero.getName() +"当前生命值为" + HP);
    }
    public static void main(String[] args){
        Support Wyi = new Support();
        Wyi.setName("巫医");
        Hero teemo = new Hero();
        teemo.setName("提莫");
        teemo.setHp(782);
		Wyi.heal();
		Wyi.heal(teemo) ;
		Wyi.heal(teemo, 345);
    }

    public String getClassName(){
        String className=null;
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] element=e.getStackTrace();
            className=element[0].getClassName();
        }
        return className;
    }
}
