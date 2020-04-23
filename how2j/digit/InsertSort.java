package digit;

public class InsertSort {
    public static void main(String[] args){
        int[] num = new int[10];
        for(int i=0; i<num.length; i++){
            num[i] = (int)(Math.random()*100);
            System.out.print(num[i] + " ");
        }
        System.out.println();
        new InsertSort().insertSort(num);
        for(int each : num){
            System.out.print(each + " ");
        }
    }

    public void insertSort(int arr[]){
        for(int i=1; i<arr.length; ++i){
            for(int j=i; j>0&&arr[j-1]>arr[j]; --j){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

