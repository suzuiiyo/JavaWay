import java.util.Scanner;

public class CopyArray{
    public static void main(String[] args){
        Scanner str = new Scanner(System.in);
        System.out.println("��ֱ�������������ĳ��Ⱥ�Ԫ�ر����Լ���ʼλ�ú͸��Ƴ��ȣ���6�����֣��Կո������");
        String arr = str.nextLine();
        String[] val = arr.split(" ");
        if(val.length<6 || val.length>6){
            System.out.println("��������ݸ�ʽ�������������룡");
            return;
        }
        str.close();
        int[] num = new int[6];
        for(int i=0; i<6; i++){
            num[i] = Integer.valueOf(val[i]);
        }
        System.out.println("�������鳤�ȷֱ�Ϊ��" + num[0] + "��" + num[1]);
        System.out.println("���������Ԫ�ر��ʷֱ�Ϊ��" + num[2] + "��" + num[3]);
        System.out.println("����ճ������ʼλ�ã�" + num[4] + "\n" + "����ճ���ĳ���Ϊ��" + num[5] + "\n");

        int arrC[] = intArrGen(num[0], num[2]);
        int arrP[] = intArrGen(num[1], num[3]);
        System.out.println("������������: ");
        for(int j : arrC){
            System.out.print(j + " ");
        }
        System.out.println("\n"+"��ճ�������ǣ� ");
        for(int k : arrP){
            System.out.print(k + " ");
        }
        System.out.println(" ");
        
        int startPoint = num[4];
        int pasteLength = num[5];
        System.arraycopy(arrC, startPoint, arrP, startPoint, pasteLength);
        System.out.println("��ճ����������ǣ�");
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