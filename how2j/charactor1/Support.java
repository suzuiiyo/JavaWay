package charactor1;
import charactor.Hero;

public class Support extends Hero implements healer{
    public void heal(){
        System.out.println("����"+ this.name+"!");
    }

    public void heal(Hero hero){
        hero.getName();
        System.out.println(this.name + "��Ӣ��" + hero.getName()+ "����");
    }

    public void heal(Hero hero, int hp){
        //System.out.println(hero.hp);
        hero.getName();
        float HP = hero.getHp() + hp;
        System.out.println(this.name + "����" + hero.getName()+ ",Ϊ��ָ�" + hp + "������," + "\n" +hero.getName() +"��ǰ����ֵΪ" + HP);
    }
    public static void main(String[] args){
        Support Wyi = new Support();
        Wyi.setName("��ҽ");
        Hero teemo = new Hero();
        teemo.setName("��Ī");
        teemo.setHp(782);
		Wyi.heal();
		Wyi.heal(teemo) ;
		Wyi.heal(teemo, 345);
    }
}
