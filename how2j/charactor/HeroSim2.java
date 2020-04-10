package charactor;

public class HeroSim2 {
    String name;
    float hp;
    float attack;
    float moveSpeed;

    private HeroSim2(){}

    private static HeroSim2 instance;

    public static HeroSim2 getInstance(){
        if(null==instance){
            instance = new HeroSim2();
        }
        return instance;
    }

    public static void main(String[] args){
        HeroSim2 garen = HeroSim2.getInstance();
        garen.name = "Garen";
        garen.hp = 792;
        System.out.println("Hero's name is " + garen.name + " and its HP is " + garen.hp);
    }

}