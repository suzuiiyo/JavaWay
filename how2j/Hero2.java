public class Hero2{
    private String name;
    private float hp;
    private float Armor;
    private int moveSpeed;

    //�޲ι���
    public Hero2(){
    }
    
    //�вι���
    public Hero2(String name, float hp, float armor, int moveSpeed){
        this.name = name;
        this.hp = hp;
        Armor = armor;
        this.moveSpeed = moveSpeed;
        }

    public void legedary(){
        System.out.println("����");
    }

    public float getHp(){
        return this.hp;
    }

    public float recovery(float blood){
        return this.getHp() + blood;
    }

    public static void main(String[] args) {
        Hero2 garen = new Hero2("����", 200.342f, 70.0f, 350);
        System.out.println("��ǰѪ����" + garen.getHp());
        garen.legedary();
        System.out.println("���û�Ѫ��" + garen.recovery(100.f));
    }
}

