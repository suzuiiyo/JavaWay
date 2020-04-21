package charactor;

public interface Mortal {
    public void die();

    default public void revive(){
        System.out.println("¸´»îÖØÉú£¡");
    }
    //public void die(Hero hero);
}