import java.util.Scanner;

public class Twodim{
    public static void main(String[] args){
        Scanner str = new Scanner(System.in);
        System.out.println("请依次输入5个数，以空格隔开: ");
        String s = str.nextLine();
        String[] str1 = s.split(" ");
        if(str1.length<5 || str1.length>5){
            System.out.println("您输入的数字格式有误！");
        }
        str.close();
        int[] dim1 = new int[5];
        int[][] dim2 = new int[5][5];
        System.out.println("输出一个二维数组为: ");
        for(int i = 0; i<5; i++){
            dim1[i] = Integer.valueOf(str1[i]);
            for(int j=0; j<5; j++){
                dim2[i][j] = dim1[i] + dim1[j];
                System.out.print(dim2[i][j] + " ");
                if(j>3)
                    System.out.println();
            }
        }
    }
}