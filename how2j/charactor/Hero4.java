package charactor;

public class Hero4 {
    public static String getName(String pos){
        String result = "name" + pos;
        System.out.println(result);
        return result;
    }

    public String name = Hero4.getName("��������");
    public Hero4(){
        name = Hero4.getName("���췽��");
    }
    {
        name = Hero4.getName("��ʼ����");
    }

    public static void main(String[] args){
        new Hero4();
    }
}