import java.util.Scanner;

public class TestKg{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int k = 6;
        System.err.println("����������");
        try{
            //��ȡ��������
            int r = s.nextInt();
            //�Ƚ������Ƿ���ȡ
            if(r>=1&&r<7){
                //�ȽϹ����ջ���ĩ
                int j = r < k?0:1;
                if(j==0){
                    System.err.println("�����ǹ�����");
                }else {
                    System.err.println("��������ĩ");
                }
            }else {
                System.err.println("��������ȷ������");
            }
            }
        catch (Exception e){
                    System.err.println("��ҪϹ����");
            }
            
    }
}