package charactor;

public class Fish extends Animal implements pet {
    private String name;
    private int legs; 

    public Fish(int legs, String name){
        super(legs, name);
    }
    public Fish(){
        this(4,"�޷���");
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
            System.out.println(this.name + "û���Ȳ�����·" );
        }
        else{
            System.out.println(this.name +"��" +this.legs + "���ȣ������㣡");
        }
    }*/
    public void eat(){
        System.out.println(this.name + "�Բ�");
    }
    public void play(){
        System.out.println(this.name + "��ˮ");
    }

    public static void main(String[] args){
        Fish Wellnick = new Fish();
        Wellnick.setName("��������");
        Wellnick.setlegs(4);
        Wellnick.walk();
        Wellnick.eat();
        Wellnick.play();
    }
}