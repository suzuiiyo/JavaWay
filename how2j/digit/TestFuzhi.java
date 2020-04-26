package digit;

public class TestFuzhi {
    public static void main(String[] args){
        int[] a = {1, 2};
        int[] b = a;
        b[1] = 5;
        //int b=3;
        //a[0]=b;
        //b=5;
        System.out.println(a[0] + " " + a[1]);
    }
}