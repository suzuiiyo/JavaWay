package charactor;

public class HeroSim {
    String name;
    float hp;
    float armor;
    float attack;
    float moveSpeed;

    private HeroSim(){
    }

    private static HeroSim instance = new HeroSim();

    public static HeroSim getInstance(){
        return instance;
    }

    public static void main(String[] args){
        HeroSim garen = HeroSim.getInstance();
        garen.name = "Garen";
        garen.hp = 873;
        System.out.println("Hero's name is " + garen.name + " and it's HP is " + garen.hp);
    }
}