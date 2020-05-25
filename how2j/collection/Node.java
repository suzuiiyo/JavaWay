package collection;

import java.util.ArrayList;
import java.util.List;

public class Node {
        //���ӽڵ�
        public Node leftNode;
        //���ӽڵ�
        public Node rightNode;

        //ֵ
        public Object value;

        //���� ����
        public void add(Object v){
            //�����ǰ�ڵ�û��ֵ,�Ͱ����ݷ��ڵ�ǰ�ڵ�
            if(null == value)
                value = v;

            //�����ǰ�Ӵ�����ֵ���ͽ����ж�,������ֵ�뵱ǰֵ�Ĵ�С��ϵ
            else{
                //������ֵ, �ȵ�ǰֵС������ͬ
                if((Integer) v - ((Integer)value) <=0){
                    if(null == leftNode)
                        leftNode = new Node();              //�����ڵ��ǿյľʹ����½ڵ�
                    leftNode.add(v);                        //�����ڵ����,��ֱ���ں���add
                }
                else{
                    if(null == rightNode)
                        rightNode = new Node();             //ͬ��
                    rightNode.add(v);
                }
            }
        }

        public static void main(String[] args){
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
        }

        //����������нڵ�
        public List<Object> values(){
            List<Object> values = new ArrayList<>();
            //��ڵ�ı���
            if(null != leftNode)
                values.addAll(leftNode.values());
            //��ǰ�ڵ�
            values.add(value);
            //�ҽڵ�ı������
            if(null != rightNode)
                values.addAll(rightNode.values());

            return values;
        }
    }
    