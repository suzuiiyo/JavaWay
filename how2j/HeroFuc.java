public class HeroFuc{
    String name;
    float hp;
    float armor;
    int moveSpeed;
    void keng(){
        System.out.println("¿Ó¶ÓÓÑ£¡");
    }

    void addSpeed(int speed){
        moveSpeed += speed;
    }

    float getArmor(){
        return armor;
    }

    void OutUltimate(){
    }

    float getHp(){
        return hp;
    }

    void recovery(float blood){
    }

    public static void main(String[] args){
        HeroFuc garen = new HeroFuc();
        garen.name = "¸ÇÂ×";
        garen.moveSpeed = 350;
        garen.addSpeed(100);
    }
}