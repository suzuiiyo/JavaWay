package digit;

public class MyStringBufferCopy implements IStringBuffer{
    int capacity=16;
    int length = 0;
    char[] context; 

    public static void main(String[] args){
        MyStringBufferCopy sb = new MyStringBufferCopy("purple rain");
        System.out.println(sb);
        String str = "qwertyuioprfdsffhd";
        MyStringBufferCopy str2 = new MyStringBufferCopy(str);
        /*for(int i =0; i<10000; i++){
            str2.append((char)(Math.random()*1000));
        }*/
        str2.reverse();
        System.out.println(str);
        System.out.println(str2);
    }

    public MyStringBufferCopy(){
        context = new char[capacity];
    }

    public MyStringBufferCopy(String str){
        this();
        if(null==str){
            return;
        }
        if(capacity >= str.length()) 
            System.arraycopy(str.toCharArray(), 0, context, 0, str.length());   //���ַ���strֱ��ճ����ԭ�ַ�����
        length = str.length(); 
        
        if(capacity < str.length()) {
            capacity = context.length*2;       //�ַ�������,����Ϊԭ��������
            context = new char[capacity];   //�����µ�context������j
        }
    }

    public void append(String str){
        insert(length, str);
    }
    public void append(char c){
        append(String.valueOf(c));
    }

    public void insert(int pos, char c){
        insert(pos, String.valueOf(c));
    }
    public void insert(int pos, String str){
        if(pos<0){
            return;
        }
        if(pos>length){
            return;
        }
        if(null==str){
            return;
        }
        while(capacity < str.length() + length){
            capacity = (int)((str.length() + length)*1.5f);  //û��ΪʲôҪ��float����int������
            char[] newContext = new char[capacity];
            System.arraycopy(context, 0, newContext, 0, length);
            context = newContext;   //���ݺ�j�����鸳ֵ��ԭ��������
        }
        System.arraycopy(context, pos, context, pos+str.length(), length-pos);
        System.arraycopy(str.toCharArray(), 0, context, pos, str.length());
        length = length + str.length();
    }

    public void delete(int start){
        delete(start, length-(length-start));
    }
    public void delete(int start , int end){
        if(start<0)
            return;
        if(start>length)
            return;
        if(end<0)
            return;
        if(end>length)
            return;
        if(end<start)
            return;

        System.arraycopy(context, end, context, start, length-end); //����end��ʼ�ĺ�����ַ���ȫ�����Ƶ���startλ�ÿ�ʼj
        length = length - (end - start);
    }

    public void reverse(){
        for(int i = 0; i<length/2; i++){
            char temp = context[i];
            context[i] = context[length-i-1];   //�±��Ϊlength-1
            context[length-i-1] = temp;
        }
    }
    
    public int length(){
        return length;
    }

    public String toStirng(){               //��дtoString����
        char[] realContext = new char[length];
        System.arraycopy(context, 0, realContext, 0, length);
        return new String(realContext);   //����һ��realContex�ַ�������
    }
}