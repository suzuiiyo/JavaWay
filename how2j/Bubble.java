public class Bubble{
    public static void main(String[] args){
        int[] a = new int[10];
        for(int i=0; i<a.length; i++){
            a[i] = (int)(Math.random()*100);
        }
        bubbleSort(a);
        for(int j=0; j<a.length; j++){
            System.out.println(a[j]);
        }
        
    }
    public static void bubbleSort(int[] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length-i-1; j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
}