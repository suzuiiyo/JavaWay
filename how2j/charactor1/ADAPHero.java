package charactor1;
import charactor.Hero;
import charactor.Mortal;

public class ADAPHero extends Hero implements AD, AP, Mortal {

    public void magicAttack(){
        System.out.println(this.name + "ʹ�ü���");
    }
    public void magicAttack(Hero hero, float hp){
        String extName = hero.getName();
        System.out.println(this.name + "ʹ�ü��ܶ�" + extName + "�����" + hp + "���˺�");
    }
    
    public void physicAttack(){
        System.out.println(this.name + "���𹥻�");
    }
    public void physicAttack(Hero hero, float hp){
        String extName = hero.getName();
        System.out.println(this.name + "�����չ���" + extName + "�����" + hp + "���˺�");
    }
    public void die(){
        System.out.println("���˽������");
    }
    public void die(Hero hero){
        String extName = hero.getName();
        System.out.println(extName + ",���˽������," + this.name);
    }

    public static void main(String[] args){
        ADAPHero QOP = new ADAPHero();
        QOP.setName("ʹ��Ů��");
        Hero AM = new Hero();
        AM.setName("�з�ʦ");

        QOP.physicAttack();
        QOP.physicAttack(AM, 134);
        QOP.magicAttack();
        QOP.magicAttack(AM, 342);

        QOP.die(AM);
    }
}