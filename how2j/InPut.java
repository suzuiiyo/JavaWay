import java.util.Scanner;

public class InPut{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("����������");
        int i = s.nextInt();
        System.out.println("��ȡ��������" + i);
        System.out.println("�������ַ���");
        String rn = s.nextLine();
        String a = s.nextLine();
        //System.out.println("��ȡ���ַ�����: " + rn);
        System.out.println("��ȡ���ַ�����: " + a);
    }
}