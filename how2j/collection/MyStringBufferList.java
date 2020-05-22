package collection;
import java.util.ArrayList;

import digit.IStringBuffer;
import exception.IndexIsNagetiveException;
import exception.IndexOutOfRangeException;

public class MyStringBufferList implements IStringBuffer{
    ArrayList<Character> ch = new ArrayList<>();
    public MyStringBufferList() {
    }

    public MyStringBufferList(String str){
        if (null == str){
            return;
        }else{
            char[] strCh = str.toCharArray();
            for(char c : strCh)
                ch.add(c);
        }
    }

    public void append(String str){
        try {
            insert(ch.size(), str);
        } catch (NullPointerException | IndexIsNagetiveException e) {
            System.out.println("��ʾ������쳣��Ϣ" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void append(char c) {
        append(String.valueOf(c));
    }

    public void insert(int pos, char b){
        try {
            insert(pos, String.valueOf(b));
        } catch (NullPointerException | IndexIsNagetiveException e) {
            System.out.println("��ʾ������쳣��Ϣ" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insert(int pos, String str) throws IndexIsNagetiveException{     //��add(int pos, Object obj)����
        if(pos<0){
            throw new IndexIsNagetiveException("pos��ֵ����С��0");
        }else{
            /*ArrayList<Character> chars = new ArrayList<>();         //��Stringת����ArrayList<Charater>
            for(char c : str.toCharArray()){
                chars.add(c);
            }*/
            char[] chars = str.toCharArray();
            char[] chTail = new char[ch.size()-pos];
            //System.out.println(ch + "ɾβ��ǰ");
            /*Iterator iteCh = ch.iterator();                 //ת���ɵ�����
            for(int i=0; i<pos ; i++){
                chTail[i] = ch.get(pos + i);              //��β���ϵ�char��������
                while(iteCh.hasNext()){
                    if(iteCh.next() == ch.get(pos + i))     //��ch��pos����Ķ���ɾ��
                        iteCh.remove();
                }
            }*/
            for(int i=0; i<chTail.length; i++){
                chTail[i] = ch.get(pos + i);             //��β�ͱ�������
            }
            while(ch.size()>pos){                        //ֻҪch�ĳ��ȴ���pos����һֱɾ,ɾ��Ϊֹ��ֻ��posǰ���Ԫ��
                ch.remove(pos);
            }
            //System.out.println("\n" + ch + "ɾβ�ͺ�");
            for(int i=0; i<str.length(); i++){
                ch.add(chars[i]);                    //��chars�����charȫ����ӵ�ch��
            }
            for(int i=0; i<chTail.length; i++){
                ch.add(chTail[i]);                   //��char��ӵ�ch��
            }
        }
    }

    public void delete(int start){
        try{
            delete(start, ch.size());
        }catch(IndexIsNagetiveException | IndexOutOfRangeException e){
            System.out.println("ͻ��һ������");
            e.printStackTrace();
        }
    }

    public void delete(int start, int end) throws IndexIsNagetiveException, IndexOutOfRangeException{
        char[] chTail = new char[ch.size() - end];
        /*Iterator iteCh = ch.iterator();
        for(int i=start; i<ch.size(); i++){
            while(iteCh.hasNext()){
                if(iteCh.next() == ch.get(i))
                    iteCh.remove();
            }
        }*/
        for(int i=0 ; i<ch.size() - end; i++){
            chTail[i] = ch.get(end + i);                //��end֮���β�ͱ�������
        }
        while(ch.size()>start){
            ch.remove(start);                           //��startǰ��ı���,start�����ȫɾ��
        }
        for(int i=0; i<chTail.length; i++){
            ch.add(chTail[i]);                          //��end��ʼ��β�ͼӻ�ȥ
        }
        
        if(start<0 || end <0){
            throw new IndexIsNagetiveException("ɾ������ʼλ�ò���С��0");
        }
        if(start >= end){
            throw new IndexOutOfRangeException("ɾ���ĳ�ʼλ�ò��ܴ����ַ�������Ҳ���ܱ�ĩβλ�ô�");
        }            
    }

    public void reverse(){
        Object[] objCh = ch.toArray();
        for(int i=0; i<objCh.length/2; i++){
            Object temp = objCh[i];
            objCh[i] = objCh[objCh.length - i-1];
            objCh[objCh.length - i-1] = temp;
        }
        /*while(ch.size() != 0){                  //ch.size��Ϊ0һֱɾ����ֱ��ɾ��
            ch.remove(0);
        }*/
        ch.clear();                             //���
        for(Object ob : objCh){
            ch.add((char)ob);                   //����������ֻ��ת��Ϊobject����
        }
    }

    public int length(){
        return ch.size();
    }

    public String toString(){
        return String.valueOf(ch);              //����ArrayList��string��ʽ,���򷵻ع�ϣֵ
    }

    public static void main(String[] args) throws IndexIsNagetiveException, IndexOutOfRangeException {
        MyStringBufferList msbl = new MyStringBufferList("there light");
        
        System.out.println(msbl);
        msbl.insert(7, "let");
        System.out.println(msbl);

        msbl.insert(3, 'b');
        System.out.println(msbl);
        msbl.insert(2, "God say");
        System.out.println(msbl);
        msbl.append('!');
        System.out.println(msbl);
        msbl.append("???");
        System.out.println(msbl);
        msbl.reverse();
        System.out.println(msbl);
        msbl.delete(2, 7);
        System.out.println(msbl);
        msbl.delete(5);
        System.out.println(msbl);
        System.out.println(msbl.length());

        String str= "qwertyuiopefdgfhgddfsd";
        MyStringBufferList str2 = new MyStringBufferList(str);
        double t5=System.currentTimeMillis();
        for(int j=0; j<10; j++)
            str2.append((char)(Math.random()*1000));
        double t6 = System.currentTimeMillis();
        System.out.println(str2);
        System.out.printf("MyStringBufferList��ʱ: %.2f\n", t6-t5);
    }
}