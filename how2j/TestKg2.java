import java.util.Scanner;

public class TestKg2{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入星期：");
        while(true){
            try{
                int i = s.nextInt();
                if(i<8&&i>0){
                    System.out.println(i>5?("今天是周末"):("今天是工作日"));
                    System.out.println(" ");
                    System.out.println("请输入星期: ");
                }else{
                    System.out.println("请输入正确的星期：");
                    }
                }
            catch (Exception e)
                {
                    System.err.println("请输入数字!");
                    s.close();
                    break;
                }
        }
    }
}
