package collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class comparatorTreeSet {
    public static void main(String[] args) {
        Comparator<Integer> c = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        };

        Set<Integer> treeSet = new TreeSet<>();
        Set<Integer> treeSet2 = new TreeSet<>(c);
        for(int i=0; i<30; i++){
            treeSet.add(i);
            treeSet2.add(i);
        }
        System.out.println(treeSet);
        System.out.println(treeSet2);
    }
}