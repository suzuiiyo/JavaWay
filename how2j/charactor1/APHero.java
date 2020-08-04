package charactor1;
import charactor.Hero;
import charactor.Mortal;

public class APHero extends Hero implements AP, Mortal{
    public APHero(){};

    public APHero(String name){
        this.name = name;
    }
    public void magicAttack(){
        System.out.println(this.name + "�����˷�����");
    }

    public void magicAttack(Hero hero){
        String extName = hero.getName();
        System.out.println(this.name + "��" + extName +"�����˷�����");
    }

    public void magicAttack(Hero hero, float hp){
        String extName = hero.getName();
        System.out.println(this.name + "��" + extName + "�����" + hp + "��ħ���˺�");
    }
    
    public void die(){
        System.out.println("��������һ��");
    }
    public void die(Hero hero){
        String extName = hero.getName();
        System.out.println(extName + ",��������һ��");
    }
    public static void main(String[] args){
        APHero bm = new APHero();
        bm.name = "����";

        Hero h1 = new Hero();
        h1.setName("�Ȼ�ħŮ");
        Hero h2 = new Hero();
        h2.setName("�㶺ħ��ʦ");

        bm.magicAttack();
        bm.magicAttack(h1);
        bm.magicAttack(h1, 345);
        bm.attack(h1, h2);

        bm.die(h2);
    }
    /* public void attack(){
        System.out.println(name + "������һ�ι��������ǲ�ȷ��������˭");
    }
    public void attack(Hero h1){
        System.out.println(name + "��" + h1.name + "������һ�ι���");
    }
    public void attack(Hero h1, Hero h2){
        System.out.println(name + "ͬʱ��" + h1.name + "��" +h2.name + "�����˹���");
    }
    */
    public void attack(Hero... heros){
        for(int i=0; i<heros.length; i++){
            float hurt = (float)Math.random()*100;    
            System.out.println(name + "������" + heros[i].getName() + ",�����" +hurt +"��ħ���˺�");
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