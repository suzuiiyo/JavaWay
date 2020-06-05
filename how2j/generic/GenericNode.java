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
        System.out.println("\n当前节点的值" + roots.value);
        System.out.println("遍历左子树：" + roots.leftNode.values() + " ");
        System.out.println();
        System.out.println("遍历右子树：" + roots.rightNode.values() + " ");
        System.out.println();
        System.out.println("中序遍历二叉树：" + roots.values() + " ");
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
    //递归法中序遍历
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