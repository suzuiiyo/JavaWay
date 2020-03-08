import java.util.Scanner;

public class TestKg{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int k = 6;
        System.out.println("请输入星期");
        try{
            //获取输入星期
            int r = s.nextInt();
            //比较输入是否争取
            if(r>=1&&r<7){
                //比较工作日或周末
                int j = r < k?0:1;
                if(j==0){
                    System.out.println("今天是工作日");
                }else {
                    System.out.println("今天是周末");
                }
            }else {
                System.out.println("请输入正确的星期");
            }
            }
        catch (Exception e)
            {
                    System.err.println("不要瞎捣乱");
            }
        s.close();
    }
}