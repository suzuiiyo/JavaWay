package charactor;

public class ADHero extends Hero{
    public static void main(String[] args){
        ADHero bh = new ADHero();
        bh.name = "�ͽ�����";

        Hero h1 = new Hero();
        h1.name = "��Ĭ��ʿ";
        Hero h2 = new Hero();
        h2.name = "���˽���";

        bh.attack(h1);
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
            System.out.println(name + "������" + heros[i].name);
        }
    }
}