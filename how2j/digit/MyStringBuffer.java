package digit;

import exception.IndexIsNagetiveException;
import exception.IndexOutOfRangeException;
import exception.NullPointerException;

public class MyStringBuffer implements IStringBuffer {
    int capacity = 16;
    int length = 0;
    char[] value;

    public MyStringBuffer() {
        value = new char[capacity];
    }

    public MyStringBuffer(String str) {
        this();
        if (null == str)
            return;

        if (capacity < str.length()) {
            capacity = value.length * 2;
            value = new char[capacity];
        }

        if (capacity >= str.length())
            System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
        length = str.length();
    }

    public void append(String str) {
        try {
            insert(length, str);
        } catch (NullPointerException | IndexIsNagetiveException | IndexOutOfRangeException e) {
            System.out.println("��ʾ������쳣��Ϣ" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void append(char c) {
        append(String.valueOf(c));
    }

    public void insert(int pos, char b) {
        try {
            insert(pos, String.valueOf(b));
        } catch (NullPointerException | IndexIsNagetiveException | IndexOutOfRangeException e) {
            System.out.println("��ʾ������쳣��Ϣ" + e.getMessage());
            e.printStackTrace();
        }
    }

        public void insert(int pos, String b) throws IndexIsNagetiveException, IndexOutOfRangeException, NullPointerException {
            //����
            while(length+b.length()>capacity){
                capacity = (int)((length+b.length())*1.5f);
                char[] newValue =new char[capacity];
                System.arraycopy(value, 0, newValue, 0, length);
                value = newValue;
            }

            char[] cs = b.toCharArray();
            //�Ȱ��Ѿ����ڵ�����������
            System.arraycopy(value, pos, value, pos+cs.length, length-pos);
            //��ҩ��������ݲ��뵽ָ��λ��
            System.arraycopy(cs, 0, value, pos, cs.length);

            length = length + cs.length;

            if(pos<0){
                throw new IndexIsNagetiveException("pos��ֵ����С��0!");
            }
            if(pos>length){
                throw new IndexOutOfRangeException("pos��ֵ���ܴ����ַ������ȣ�");
            }
            /*if(null==b){
                throw new NullPointerException("�ַ�������Ϊ�գ�");    
            }*/
        }
        
        public void delete(int start){
            try {
                delete(start, length);                      //�˴���һ��bug, ����start��ֵ�Ƕ��ٶ����׳��쳣 
            } catch (IndexIsNagetiveException | IndexOutOfRangeException e) {  //���Է����ǵ�end>lengthʱ���Զ��׳�IndexOutOfBoundsException,������Խ��
                System.out.println("ͻ��һ������");
                e.printStackTrace();
                System.out.println(start + " " + length);
            }
        }
        public void delete(int start, int end) throws IndexIsNagetiveException, IndexOutOfRangeException{
            System.arraycopy(value, end, value, start, length-end);
            length-=end-start;

            if(start<0 || end <0){
                throw new IndexIsNagetiveException("ɾ���ĳ�ʼλ�ò���С��0");
            }
            if(start>length || start >= end){
                throw new IndexOutOfRangeException("ɾ���ĳ�ʼλ�ò��ܴ����ַ�������Ҳ���ܱ�ĩβλ�ô�");
            }            
        }
        public void reverse(){
            for(int i=0; i<length / 2; i++){
                char temp = value[i];
                value[i] = value[length - i -1];
                value[length -i -1] = temp;
            }
        }
        public int length(){
            return length;
        }

        public String toString(){              //object���toString����������ÿ��������ַ��������ʽ
            char[] realValue = new char[length];
            System.arraycopy(value, 0, realValue, 0, length);
            return new String(realValue);
        }

        public static void main(String[] args) throws IndexIsNagetiveException, IndexOutOfRangeException, NullPointerException{
            MyStringBuffer sb = new MyStringBuffer("there light");
            //sb.reverse();
            System.out.println(sb);
            sb.insert(7, "let");
            System.out.println(sb);

            sb.insert(3, "be");
            System.out.println(sb);
            sb.insert(2, "God say");
            System.out.println(sb);
            sb.append('!');
            System.out.println(sb);
            sb.append("???");
            System.out.println(sb);
            sb.reverse();
            System.out.println(sb);
            sb.delete(2, 7);
            System.out.println(sb);
            sb.delete(5);
            System.out.println(sb);

            String str= "qwertyuiopefdgfhgddfsd";
            MyStringBuffer str2 = new MyStringBuffer(str);
            double t5=System.currentTimeMillis();
            for(int j=0; j<10; j++)
                str2.append((char)(Math.random()*1000));
            double t6 = System.currentTimeMillis();
            System.out.println(str2);
            System.out.printf("MyStringBuffer��ʱ: %.2f\n", t6-t5);
        }
		//public void append(int i) {
		//}
}

