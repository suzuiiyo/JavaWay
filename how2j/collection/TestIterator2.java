package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestIterator2 {
    public static void main(String[] args) {
        List<test> l = new ArrayList<>();       //�Զ����test��������
        System.out.println("��ʼ��ʱl���test���ݵ�count��ֵ: ");
        for(int i=0; i<3; i++){
            test pi = new test();
            l.add(pi);
            System.out.println(pi.kkk[0].count);
        }
        Iterator<test> ite = l.iterator();
        System.out.println("�õ������޸�test���ݵ�count��ֵ: ");
        while(ite.hasNext()){
            test a = ite.next();
            a.kkk[0].count = 2;
            System.out.println(a.kkk[0].count);
        }
        System.out.println("�õ������޸�֮��l��test���ݵ�count��ֵ: ");
        for(test b : l){
            System.out.println(b.kkk[0].count);                 //�����˱仯,���ô���
        }

        System.out.println("**********************");

        List<String> list = Arrays.asList("java����", "C����", "C++����");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            next = "�޸ĺ��";
            System.out.println(next);
        }
        System.out.println("�õ������޸�֮���list���String���ݵ�ֵ: ");
        System.out.println(list);                               //û�з����仯,�������ô��ݣ�ֻ����String���ɸ������ݣ����ǵ�������ʵ�������µ�String����
    }
}