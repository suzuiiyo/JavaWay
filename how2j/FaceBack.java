public class FaceBack{
    public static void main(String[] args){
        int[] a = new int[10];
        for(int i=0; i<a.length; i++){
            a[i] = (int)(Math.random()*100);
        }
        chooseSort(a);
        for(int j=0; j<a.length; j++){
            System.out.print(a[j] + " ");
        }
        System.out.println();
        bubbleSort(a);
        for(int k=0; k<a.length; k++){
            System.out.print(a[k] + " ");
        }
    }

    public static void chooseSort(int[] array){
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                if(array[i]>array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void bubbleSort(int[] arrayb){
        for(int i=0; i<arrayb.length; i++){
            for(int j=0; j<arrayb.length-i-1; j++){
                if(arrayb[j]<arrayb[j+1]){
                    int tmp = arrayb[j];
                    arrayb[j] = arrayb[j+1];
                    arrayb[j+1] = tmp;
                }
            }
        }
    }

}