package digit;

public class TestChar {
    public static void main(String[] args){
        char c1 = 'a';
        char c2 = '1';
        char c3 = '��';
        String c4 = "ab";
        System.out.format("%c %c %c %s", c1, c2, c3, c4);

        Character c = c1; //�Զ�װ��
        c1 = c; //�Զ�����
    }
}