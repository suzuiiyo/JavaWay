package collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetAllView {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<Integer>();

        for(int i=0; i<20; i++){
            numbers.add(i);
        }
        //Set���ṩget��������ȡָ��λ�õ�Ԫ��
        //numbers.get(0)

        //����Set���Բ�ȡ������iterator
        for(Iterator ite = numbers.iterator(); ite.hasNext();){
            Integer i = (Integer) ite.next();
            System.out.print(i + " ");
        }

        System.out.println("\n\n\t\t**************************\n");
        //����ʹ����ǿ��forѭ��
        for(Integer i : numbers){
            System.out.print(i + " ");
        }
    
    }
}