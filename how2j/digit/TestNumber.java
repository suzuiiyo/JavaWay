package digit;

public class TestNumber {
    public static void main(String[] args){
        int i = 5;
        //��һ���������͵ı�����ת����Integer����
        Integer it = new Integer(i);
        //��һ��Integer����ת��Ϊһ���������͵�int
        //int i2 = it.intValue();
        System.out.println(it instanceof Number);
        int i2 = it.intValue();
        System.out.println(i2);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);    
    }
}