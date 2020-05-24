package collection;

public class QuickPow {
    public static void main(String[] args) {
        long c = poww(3, 3);
        System.out.println("�����ݵ�ֵΪ��" + c);
    }

    /*private static int poww( int a, int b){       //�е㿴����
        int result = 1;
        int count =0 ;
        while(b!=0){                        //շת���
            if(b%2!=0){                     //���b������
                result *=a;                 //result��ʾa��count��
            }
            a *= a;                         //a��count+1��
            b >>=1;                        //����һλ,�൱�ڳ���2
            count++;
            System.out.printf("��%d�β�����bֵΪ:%d  %n", count, b);
            System.out.println("***************");
        }
        return result;
    }*/

    public static long poww(long a, long b){     //���ݴβ�ɶ����Ƽ���
        long ans =1;
        long base = a;
        while(b!=0){                //2^11=2^(2^3+2^1+2^0)
            if(b%2 != 0){        //���������
                ans*=base;          //�������ݣ�ż���ݶ��һ��
            }
            base*=base;             //ż������,������ż����ƽ��
            b>>=1;
        }
        return ans;
    }
}