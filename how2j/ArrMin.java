
public class ArrMin{
    public static void main(String[] args){
        int[] a = new int[10];
        for(int i=0; i<10; i++){
            a[i] = (int)(Math.random() * 100);
        }
        insertionSort(a);
        for(int j=0; j<a.length; j++){
            System.out.println(a[j]);
        }
    }

    public static void insertionSort(int[] array) {
        for (int i=0; i<array.length; i++){
            for(int j=i; j-1 >=0 &&array[j] < array[j-1]; j--){
                int tmp = array[j];
                array[j] = array[j-1];
                array[j-1] = tmp;
            }
        }
    }
}