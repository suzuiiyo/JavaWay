public class Reserve{
    public static void main(String[] args){
        int[] a = new int[10];
        for(int i=0; i<a.length; i++){
            a[i] = (int)(Math.random()*100);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for(int j=0; j<a.length/2; j++){
            int tmp = a[j];
            a[j] = a[a.length-j-1];
            a[a.length-j-1] = tmp;
        }
        for(int k=0; k<a.length; k++){
            System.out.print(a[k] + " ");
        }
    }
}