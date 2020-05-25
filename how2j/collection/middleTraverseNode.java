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
        System.out.println("value��ֵ: " + roots.value);
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
    //��������
    public void add(Object v){
        //�����ǰ�ڵ�û��ֵ,�Ͱ����ݷ��ڵ�ǰ�ڵ���
        if(null == value)
            value = v;
        //�����ǰ�ڵ���ֵ,�ͽ����жϣ�������ֵ�뵱ǰֵ�Ĵ�С��ϵ
        else{
            //������ֵ,�ȵ�ǰֵС������ͬ
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

    //����������нڵ�
    /*public List<Object> values(){
        List<Object> values = new ArrayList<>();
        //��ڵ�ı���
        if(null != leftNode)
            values.addAll(leftNode.values());
        //��ǰ�ڵ�
        values.add(1);
        //�ҽڵ�ı������
        if(null != rightNode)
            values.addAll(rightNode.values());

        return values;
    }*/
}