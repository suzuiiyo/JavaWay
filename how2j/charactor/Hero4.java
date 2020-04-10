package charactor;

public class Hero4 {
    public static String getName(String pos){
        String result = "name" + pos;
        System.out.println(result);
        return result;
    }

    public String name = Hero4.getName("属性声明");
    public Hero4(){
        name = Hero4.getName("构造方法");
    }
    {
        name = Hero4.getName("初始化块");
    }

    public static void main(String[] args){
        new Hero4();
    }
}