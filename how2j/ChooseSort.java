public class ChooseSort{
    public static void main(String[] args){
        int[] a = new int[10];
        for(int i=0; i<a.length; i++){
            a[i] = (int)(Math.random()*100);
        }
        for(int j=0; j<a.length; j++){
            for(int k = j +1; k<a.length; k++){
                if(a[j]<a[k]){
                    int tmp = a[j];
                    a[j] = a[k];
                    a[k] = tmp;
                }
            }
        }
        for(int n=0; n<a.length; n++){
            System.out.println(a[n]);
        }
    }
}