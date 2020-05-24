package collection;

public class QuickPow {
    public static void main(String[] args) {
        long c = poww(3, 3);
        System.out.println("快速幂的值为：" + c);
    }

    /*private static int poww( int a, int b){       //有点看不懂
        int result = 1;
        int count =0 ;
        while(b!=0){                        //辗转相除
            if(b%2!=0){                     //如果b是奇数
                result *=a;                 //result表示a的count次
            }
            a *= a;                         //a的count+1次
            b >>=1;                        //右移一位,相当于除以2
            count++;
            System.out.printf("第%d次操作的b值为:%d  %n", count, b);
            System.out.println("***************");
        }
        return result;
    }*/

    public static long poww(long a, long b){     //把幂次拆成二进制计算
        long ans =1;
        long base = a;
        while(b!=0){                //2^11=2^(2^3+2^1+2^0)
            if(b%2 != 0){        //如果是奇数
                ans*=base;          //奇数次幂，偶次幂多乘一次
            }
            base*=base;             //偶数次幂,正好是偶数幂平方
            b>>=1;
        }
        return ans;
    }
}