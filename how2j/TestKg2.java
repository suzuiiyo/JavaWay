import java.util.Scanner;

public class TestKg2{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.err.println("���������ڣ�");
        while(true){
            int i = s.nextInt();
            try{
                if(i<8&&i>0){
                    System.err.println(i>5?("��������ĩ"):("�����ǹ�����"));
                }else{
                    System.err.println("��������ȷ�����ڣ�");
                    }
                }
            catch (Exception e){
                    System.err.println("��������ȷ������");
                }
        }
    }
}
