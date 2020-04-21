package charactor;

public abstract class Animal {
    protected int legs;
    protected String name;

    public Animal(){};

    public Animal(int legs, String name){
        this.legs = legs;
        this.name = name;
    }
    public abstract void eat();
    
    public void walk(){
        System.out.println( this.name +"用" + legs + "条腿行走");
    }
}