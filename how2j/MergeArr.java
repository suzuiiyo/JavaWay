public class MergeArr{
    public static void main(String[] args){
        int[] len = new int[2];
        System.out.println("���ɵ���������ó��ȷֱ�Ϊ: ");
        for(int i=0; i<2; i++){
            len[i] = (int)((Math.random()+1)*5);
            System.out.print(len[i] + " ");
        }
        System.out.println();
        int[] arr1 = new int[len[0]];
        int[] arr2 = new int[len[1]];
        
        System.out.println("���ɵõ�һ������Ϊ: ");
        for(int i=0; i<arr1.length; i++){
            arr1[i] = (int)(Math.random()*100);
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        System.out.println("���ɵõڶ�������Ϊ: ");
        for(int i=0; i<arr2.length; i++){
            arr2[i] = (int)(Math.random()*100);
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        System.out.println("��������ϲ��������Ϊ: ");
        int[] arr3 = new int[arr1.length+arr2.length];
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
        for(int each : arr3){
            System.out.print(each + " ");
        }
    }
}