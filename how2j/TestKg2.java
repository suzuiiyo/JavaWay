import java.util.Scanner;

public class TestKg2{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("���������ڣ�");
        while(true){
            try{
                int i = s.nextInt();
                if(i<8&&i>0){
                    System.out.println(i>5?("��������ĩ"):("�����ǹ�����"));
                    System.out.println(" ");
                    System.out.println("����������: ");
                }else{
                    System.out.println("��������ȷ�����ڣ�");
                    }
                }
            catch (Exception e)
                {
                    System.err.println("����������!");
                    s.close();
                    break;
                }
        }
    }
}
