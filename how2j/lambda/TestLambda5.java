package lambda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class TestLambda5 {
    public static void main(String[] args) {
        /*Supplier<List> s =new Supplier<List>(){
            public List get(){
                return new ArrayList();
            }
        };*/
        /*List<Integer> l;
        l=new ArrayList<>();
        insertFirst(l, "ArrayList");

        l=new LinkedList<>();
        insertFirst(l, "LinkedList");*/

        insertFirst(ArrayList::new, "ArrayList");                       //���ù�����,����lambda���ʽ��Ϊ����
        insertFirst(LinkedList::new, "LinkedList");

    }

    //private static void insertFirst(List<Integer> l, String type){
    private static void insertFirst(Supplier<List> s, String type){             
        int total = 1000 * 100;
        final int number = 5;
        long start = System.currentTimeMillis();
        List list = s.get();
        for(int i=0; i<total; i++){
            //l.add(0, number);
            list.add(0, number);
        }
        long end = System.currentTimeMillis();
        System.out.printf("��%s��ǰ�����%d�����ݣ��ܹ���ʱ%d���� %n", type, total, end - start);
    }
}