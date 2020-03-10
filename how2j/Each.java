import java.util.Scanner;


public class Each{
    public static void main(String[] args){
/*       int[] a = new int[10];
        for(int i=0; i<a.length; i++){
            a[i] = (int)(Math.random()*100);
        }
        int max = a[0];
        for(int each : a){
            if(each > max){
                max = each;
            }
            System.out.println(each + " ");
        }
        System.out.println("The max value is " + max);
    }
    */  
        Scanner s = new Scanner(System.in);
        System.out.println("请输入数组长度和元素倍率，以空格隔开：");
        String val = s.nextLine();          //输入的两个数字以空格分隔，视为字符串
        String[] vals = val.split(" ");   //将输入的字符串以空格为界分开，并存入字符串数组中
        if(vals.length<2 || vals.length>2){
            System.out.println("输入的数值格式有误，请重新输入！");
            return;
        }
        s.close();                              //关闭s的输入
        int num1 = Integer.valueOf(vals[0]);    //将分割得到的两个String字符强制转换城int型
        int num2 = Integer.valueOf(vals[1]);

        int[] arr = new int[num1];
        int max = arr[0];
        System.out.print("生成的数组为：");
        for(int b : arr){
            b = (int)(Math.random()*num2);
            if(b>max){
                max =b;
            }
            System.out.print(b + " ");
        }
        System.out.println(" ");
        System.out.println("数组长度为: " + num1);
        System.out.println("元素倍率为： " + num2);
        System.out.println("数组中最大值为：" + max);
    }
}