package collection;

import java.util.ArrayList;
import java.util.List;

public class middleTraverseNode {

    public Node leftNode;
    public Node rightNode;
    public Object value;
    public static void main(String[] args) {
        int randoms[] = new int[]{67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
        Node roots = new Node();
        for(int number : randoms){
            roots.add(number);
            System.out.println(number);
        }
        System.out.println("value的值: " + roots.value);
        System.out.print(roots.leftNode.values() + " ");
        System.out.println();
        System.out.print(roots.rightNode.values() + " ");
        System.out.println();
        System.out.println(roots.values());
        System.out.print("\n ************************** \n");
        Integer[] nums = {67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
        TreeNode root = ConstructTree.constructTree(nums);
        TreeOperation.show(root);
    }
    //插入数据
    public void add(Object v){
        //如果当前节点没有值,就把数据放在当前节点上
        if(null == value)
            value = v;
        //如果当前节点有值,就进行判断，新增的值与当前值的大小关系
        else{
            //新增的值,比当前值小或者相同
            if((Integer) v - ((Integer)value) <=0 ){
                if(null == leftNode)
                    leftNode = new Node();
                leftNode.add(v);
            }
            else{
                if(null == rightNode)
                    rightNode = new Node();
                rightNode.add(v);
            }
        }
    }

    //中序遍历所有节点
    /*public List<Object> values(){
        List<Object> values = new ArrayList<>();
        //左节点的遍历
        if(null != leftNode)
            values.addAll(leftNode.values());
        //当前节点
        values.add(1);
        //右节点的遍历结果
        if(null != rightNode)
            values.addAll(rightNode.values());

        return values;
    }*/
}