package charactor1;
import charactor.Hero;

public class ADAPHero extends Hero implements AD, AP {

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

    public static void main(String[] args){
        ADAPHero QOP = new ADAPHero();
        QOP.setName("ʹ��Ů��");
        Hero AM = new Hero();
        AM.setName("�з�ʦ");

        QOP.physicAttack();
        QOP.physicAttack(AM, 134);
        QOP.magicAttack();
        QOP.magicAttack(AM, 342);
    }
}