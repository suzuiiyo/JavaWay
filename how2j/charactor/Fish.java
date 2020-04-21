package charactor;

public class Fish extends Animal implements pet {
    private String name;
    private int legs; 

    public Fish(int legs, String name){
        super(legs, name);
    }
    public Fish(){
        this(4,"罗非鱼");
    }

    public void setName(String name){
        this.name  = name;
    }
    public String getName(){
        return name;
    }
    public void setlegs(int legs){
        this.legs  = legs;
    }
    public int getlegs(){
        return legs;
    }

    /*public void walk(){
        if(this.legs == 0){
            System.out.println(this.name + "没有腿不能走路" );
        }
        else{
            System.out.println(this.name +"有" +this.legs + "条腿，不是鱼！");
        }
    }*/
    public void eat(){
        System.out.println(this.name + "吃草");
    }
    public void play(){
        System.out.println(this.name + "玩水");
    }

    public static void main(String[] args){
        Fish Wellnick = new Fish();
        Wellnick.setName("虎鲸威力");
        Wellnick.setlegs(4);
        Wellnick.walk();
        Wellnick.eat();
        Wellnick.play();
    }
}