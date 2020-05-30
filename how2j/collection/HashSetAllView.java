package collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetAllView {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<Integer>();

        for(int i=0; i<20; i++){
            numbers.add(i);
        }
        //Set不提供get方法来获取指定位置的元素
        //numbers.get(0)

        //遍历Set可以采取迭代器iterator
        for(Iterator ite = numbers.iterator(); ite.hasNext();){
            Integer i = (Integer) ite.next();
            System.out.print(i + " ");
        }

        System.out.println("\n\n\t\t**************************\n");
        //或者使用增强型for循环
        for(Integer i : numbers){
            System.out.print(i + " ");
        }
    
    }
}