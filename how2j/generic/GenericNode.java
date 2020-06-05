package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericNode<T> {
    public static void main(String[] args) {
        int randoms[] = new int[]{72, 32, 12, 34, 65, 78, 53, 656, 78, 964};
        GenericNode<Integer> roots = new GenericNode<>(); 
        for(int n : randoms){
            roots.add(n);
            System.out.print(n + " ");
        }
        System.out.println("\n��ǰ�ڵ��ֵ" + roots.value);
        System.out.println("������������" + roots.leftNode.values() + " ");
        System.out.println();
        System.out.println("������������" + roots.rightNode.values() + " ");
        System.out.println();
        System.out.println("���������������" + roots.values() + " ");
    }

    public T value;
    public GenericNode<T> leftNode;
    public GenericNode<T> rightNode;

    public void add(T v){
        if(null == value)
            value =v;
        else{
            if((Integer)v - (Integer) value <=0){
                if(leftNode==null)
                    leftNode = new GenericNode<>();
                leftNode.add(v);
            }
            else{
                if(rightNode == null)
                    rightNode = new GenericNode<>();
                rightNode.add(v);
            }
        }
    }
    //�ݹ鷨�������
    public List<T> values(){
        List<T> nodelist = new ArrayList<>();
        if(leftNode != null)
            nodelist.addAll(leftNode.values());
        
        nodelist.add(value);

        if(rightNode != null)
            nodelist.addAll(rightNode.values());

        return nodelist;
    }
}