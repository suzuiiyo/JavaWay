package charactor;

public class Cat extends Animal implements pet {
    private String name; 
    public Cat(String name){
        super(4, name);
    }
    public Cat(){
        this("åßÂŞÃ¨");
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void play(){
        System.out.println(this.name + "Ï²»¶Íæ½ÜÃ×");
    }

    public void eat(){
        System.out.println(this.name + "Ï²»¶³ÔÓã");
    }

    public static void main(String[] args){
        Cat Tom = new Cat();
        Tom.setName("ÌÀÄ·Ã¨");
        Tom.play();
        Tom.eat();
        Tom.walk();
    }

}