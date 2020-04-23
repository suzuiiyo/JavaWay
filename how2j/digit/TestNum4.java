package digit;

import java.util.Locale;

public class TestNum4 {
    public static void main(String[] args){
        System.out.println("���ǻ��з�%n");
        System.out.format("���ǻ��з�%n");

        int year = 2020;
        //�ܳ���,����룬��0�� ǧλ�ָ�����С����λ�������ػ����
        
        //ֱ�Ӵ�ӡ����
        System.out.format("%d%n", year);
        //ֱ�ӳ�����8��Ĭ���Ҷ���
        System.out.format("%8d%n", year);
        //�ܳ�����8�������
        System.out.format("%-8d%n", year);
        //�ܳ�����8��������0
        System.out.format("%08d%n", year);
        //ǧλ�ָ���
        System.out.format("%, 8d%n", year*10000);

        //С����λ��
        System.out.format("%.2f%n", Math.PI);

        //��ͬ���ҵ�ǧλ�ָ���
        System.out.format(Locale.FRANCE, "%, 2f%n",Math.PI*10000);
        System.out.format(Locale.US, "%, 2f%n",Math.PI*10000);
        System.out.format(Locale.UK, "%, 2f%n",Math.PI*10000);
    }
}