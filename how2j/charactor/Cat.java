package charactor;

public class Cat extends Animal implements pet {
    private String name; 
    public Cat(String name){
        super(4, name);
    }
    public Cat(){
        this("����è");
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void play(){
        System.out.println(this.name + "ϲ�������");
    }

    public void eat(){
        System.out.println(this.name + "ϲ������");
    }

    public static void main(String[] args){
        Cat Tom = new Cat();
        Tom.setName("��ķè");
        Tom.play();
        Tom.eat();
        Tom.walk();
    }

}