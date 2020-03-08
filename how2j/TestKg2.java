import java.util.Scanner;

public class TestKg2{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.err.println("请输入星期：");
        while(true){
            int i = s.nextInt();
            try{
                if(i<8&&i>0){
                    System.err.println(i>5?("今天是周末"):("今天是工作日"));
                }else{
                    System.err.println("请输入正确的星期：");
                    }
                }
            catch (Exception e){
                    System.err.println("请输入正确的星期");
                }
        }
    }
}
