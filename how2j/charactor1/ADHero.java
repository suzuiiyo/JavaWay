package charactor1;
import charactor.Hero;

public class ADHero extends Hero implements AD{
    
    public void physicAttack(){
        System.out.println(this.name + "�������չ���");
    }

    public void physicAttack(Hero hero){
        String extName = hero.getName();
        System.out.println(this.name + "��" + extName +"�������չ���");
    }

    public void physicAttack(Hero hero, float hp){
        String extName = hero.getName();
        System.out.println(this.name + "��" + extName + "�����" + hp + "�������˺�");
    }
    
    public static void main(String[] args){
        ADHero bh = new ADHero();
        bh.name = "�ͽ�����";

        Hero h1 = new Hero();
        h1.setName("��Ĭ��ʿ");
        Hero h2 = new Hero();
        h2.setName("ʹ��Ů��");

        bh.physicAttack();
        bh.physicAttack(h1);
        bh.physicAttack(h1, 345);
        bh.attack(h1, h2);
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
            System.out.println(name + "������" + heros[i].getName());
        }
    }
}