import java.util.Scanner;

public class CopyArray{
    public static void main(String[] args){
        Scanner str = new Scanner(System.in);
        System.out.println("请分别输入两个数组的长度和元素倍率以及起始位置和复制长度，共6个数字，以空格隔开：");
        String arr = str.nextLine();
        String[] val = arr.split(" ");
        if(val.length<6 || val.length>6){
            System.out.println("输入的数据格式有误，请重新输入！");
            return;
        }
        str.close();
        int[] num = new int[6];
        for(int i=0; i<6; i++){
            num[i] = Integer.valueOf(val[i]);
        }
        System.out.println("两个数组长度分别为：" + num[0] + "和" + num[1]);
        System.out.println("两个数组的元素倍率分别为：" + num[2] + "和" + num[3]);
        System.out.println("复制粘贴的起始位置：" + num[4] + "\n" + "复制粘贴的长度为：" + num[5] + "\n");

        int arrC[] = intArrGen(num[0], num[2]);
        int arrP[] = intArrGen(num[1], num[3]);
        System.out.println("被复制数组是: ");
        for(int j : arrC){
            System.out.print(j + " ");
        }
        System.out.println("\n"+"被粘贴数组是： ");
        for(int k : arrP){
            System.out.print(k + " ");
        }
        System.out.println(" ");
        
        int startPoint = num[4];
        int pasteLength = num[5];
        System.arraycopy(arrC, startPoint, arrP, startPoint, pasteLength);
        System.out.println("被粘贴后的数组是：");
        for(int l : arrP){
            System.out.print(l + " ");
        }
    }

    public static int[] intArrGen(int i, int j){
        int[] arr = new int[i];
        for(int k=0; k<i; k++){
            arr[k] = (int)(Math.random()*j);
        }
        return arr;
    }
}