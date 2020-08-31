package matrix;

public class matrixQuickPoww {
    public static void main(String[] args) {
        long[][] a = new long[80][80];
        long[][] b = new long[80][80];
        for(int i=0; i<80; i++){
            for(int j=0; j<80; j++){
                a[i][j] = i*j;
                b[i][j] = i+j;
                System.out.println(a[i][j]);
                System.out.println(b[i][j]);
            }
        }
        long[][] c = multiply(a, b, 8, 7);
        System.out.println(c[1][1]);
            //if(i==79){
            //  System.out.println("\n");
            //}
    }

    private static long[][] multiply(long[][] a, long[][] b, int n, int mod){
        long[][] result = new long[80][80];
        for(int i=1; i<2*n; i++){
            for(int j=1; j<2*n; j++){
                for(int k=1; k<2*n; k++){
                    result[i][j] += ((a[i][k]*b[k][j]%mod));
                    result[i][j] %= mod;
                }
            }
        }
        return result;
    }

    /*private static long[][] quick(int k, int n, int mod){
        long[][] cur = new long[80][80];
        long[][] result = new long[80][80];

        for(int i=1; i<2*n; i++){                   //µ¥Î»¾ØÕó
            result[i][i]=1;
        }
        cur = matrix;

        while(k!=0){
            if(k%2 == 1)
                result = multiply(result, cur, n, mod);
                cur = multiply(cur, cur, n, mod);
                k/=2;
        }
        return result;
    }*/
}