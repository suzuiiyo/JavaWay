package matrix;

public class poww {
    public static void main(String[] args) {
        poww Tt = new poww();
        long a = Tt.poww(2, 2);
        System.out.println(a);
    }

    public long poww(long a, long b){
        long result = 1;
        long base = a;
        while(b!=0){
            if(b%2!=0){
                result *= base;
            }
            base *= base;
            b>>=1;
        }
        return result;
    }
}