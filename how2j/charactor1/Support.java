package charactor1;
import charactor.Hero;

public class Support extends Hero{
    public void heal(){
        System.out.println("�����Լ���");
    }

    public void heal(Hero hero){
        System.out.println("��Ӣ��" + hero + "����");
    }

    public void heal(Hero hero, int hp){
        System.out.println("��Ӣ��" + hero + "�ָ�" + hp + "������");
    }
}