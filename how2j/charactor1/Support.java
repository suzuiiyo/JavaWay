package charactor1;
import charactor.Hero;

public class Support extends Hero implements healer{
    public void heal(){
        System.out.println("�����Լ���");
    }

    public void heal(Hero hero){
        System.out.println("��Ӣ��" + hero.name + "����");
    }

    public void heal(Hero hero, int hp){
        System.out.println("��Ӣ��" + hero.name + "�ָ�" + hero.hp + "������");
    }
    public static void main(String[] args){
        Support Wyi = new Support();
        Hero teemo = new Hero();
		Wyi.heal(teemo);
    }
}