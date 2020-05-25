package collection;

import java.util.Deque;
import java.util.LinkedList;

public class ConstructTree {
    public static TreeNode constructTree(Integer[] nums){
        if (nums.length == 0) return new TreeNode(0);
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        // ����һ�����ڵ�
        TreeNode root = new TreeNode(nums[0]);
        nodeQueue.offer(root);
        TreeNode cur;
        // ��¼��ǰ�нڵ��������ע�ⲻһ����2���ݣ�������һ���зǿսڵ��������2��
        int lineNodeNum = 2;
        // ��¼��ǰ���������������еĿ�ʼλ��
        int startIndex = 1;
        // ��¼������ʣ���Ԫ�ص�����
        int restLength = nums.length - 1;

        while(restLength > 0) {
            // ֻ�����һ�п��Բ����������б���������
//            // �����������������Ǵ���ģ�ֱ����������
//            if (restLength < lineNodeNum) {
//                System.out.println("Wrong Input!");
//                return new TreeNode(0);
//            }
            for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
                // ˵���Ѿ���nums�е��������꣬��ʱӦֹͣ������������ֱ�ӷ���root
                if (i == nums.length) return root;
                cur = nodeQueue.poll();
                if (nums[i] != null) {
                    cur.leftNode = new TreeNode(nums[i]);
                    nodeQueue.offer(cur.leftNode);
                }
                // ͬ�ϣ�˵���Ѿ���nums�е��������꣬��ʱӦֹͣ������������ֱ�ӷ���root
                if (i + 1 == nums.length) return root;
                if (nums[i + 1] != null) {
                    cur.rightNode = new TreeNode(nums[i + 1]);
                    nodeQueue.offer(cur.rightNode);
                }
            }
            startIndex += lineNodeNum;
            restLength -= lineNodeNum;
            lineNodeNum = nodeQueue.size() * 2;
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println(root);
    }
}