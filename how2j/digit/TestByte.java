package digit;

public class TestByte {
    public static void main(String[] args){
        byte i = 1;
        Byte it = new Byte(i);
        Byte it2 = i;
        System.out.println(it instanceof Number);
        
        Byte i2 = it.byteValue();
        Byte i3 = it;

        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
    }
}