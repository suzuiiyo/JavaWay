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
        System.out.println("���������鳤�Ⱥ�Ԫ�ر��ʣ��Կո������");
        String val = s.nextLine();          //��������������Կո�ָ�����Ϊ�ַ���
        String[] vals = val.split(" ");   //��������ַ����Կո�Ϊ��ֿ����������ַ���������
        if(vals.length<2 || vals.length>2){
            System.out.println("�������ֵ��ʽ�������������룡");
            return;
        }
        s.close();                              //�ر�s������
        int num1 = Integer.valueOf(vals[0]);    //���ָ�õ�������String�ַ�ǿ��ת����int��
        int num2 = Integer.valueOf(vals[1]);

        int[] arr = new int[num1];
        int max = arr[0];
        System.out.print("���ɵ�����Ϊ��");
        for(int b : arr){
            b = (int)(Math.random()*num2);
            if(b>max){
                max =b;
            }
            System.out.print(b + " ");
        }
        System.out.println(" ");
        System.out.println("���鳤��Ϊ: " + num1);
        System.out.println("Ԫ�ر���Ϊ�� " + num2);
        System.out.println("���������ֵΪ��" + max);
    }
}