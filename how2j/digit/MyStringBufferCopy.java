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
            System.arraycopy(str.toCharArray(), 0, context, 0, str.length());   //将字符串str直接粘贴到原字符串中
        length = str.length(); 
        
        if(capacity < str.length()) {
            capacity = context.length*2;       //字符串扩容,容量为原来的两倍
            context = new char[capacity];   //生成新的context字数组j
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
            capacity = (int)((str.length() + length)*1.5f);  //没懂为什么要先float化再int化？？
            char[] newContext = new char[capacity];
            System.arraycopy(context, 0, newContext, 0, length);
            context = newContext;   //拓容后j得数组赋值给原来的数组
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

        System.arraycopy(context, end, context, start, length-end); //将从end开始的后面的字符串全都复制到从start位置开始j
        length = length - (end - start);
    }

    public void reverse(){
        for(int i = 0; i<length/2; i++){
            char temp = context[i];
            context[i] = context[length-i-1];   //下标和为length-1
            context[length-i-1] = temp;
        }
    }
    
    public int length(){
        return length;
    }

    public String toStirng(){               //重写toString方法
        char[] realContext = new char[length];
        System.arraycopy(context, 0, realContext, 0, length);
        return new String(realContext);   //返回一个realContex字符串对象
    }
}