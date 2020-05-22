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
            System.out.println("显示具体的异常信息" + e.getMessage());
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
            System.out.println("显示具体的异常信息" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insert(int pos, String str) throws IndexIsNagetiveException{     //有add(int pos, Object obj)方法
        if(pos<0){
            throw new IndexIsNagetiveException("pos的值不能小于0");
        }else{
            /*ArrayList<Character> chars = new ArrayList<>();         //将String转换成ArrayList<Charater>
            for(char c : str.toCharArray()){
                chars.add(c);
            }*/
            char[] chars = str.toCharArray();
            char[] chTail = new char[ch.size()-pos];
            //System.out.println(ch + "删尾巴前");
            /*Iterator iteCh = ch.iterator();                 //转换成迭代器
            for(int i=0; i<pos ; i++){
                chTail[i] = ch.get(pos + i);              //把尾巴上的char保存起来
                while(iteCh.hasNext()){
                    if(iteCh.next() == ch.get(pos + i))     //将ch里pos后面的对象删除
                        iteCh.remove();
                }
            }*/
            for(int i=0; i<chTail.length; i++){
                chTail[i] = ch.get(pos + i);             //把尾巴保存起来
            }
            while(ch.size()>pos){                        //只要ch的长度大于pos，就一直删,删完为止，只留pos前面的元素
                ch.remove(pos);
            }
            //System.out.println("\n" + ch + "删尾巴后");
            for(int i=0; i<str.length(); i++){
                ch.add(chars[i]);                    //把chars里面的char全部添加到ch里
            }
            for(int i=0; i<chTail.length; i++){
                ch.add(chTail[i]);                   //把char添加到ch里
            }
        }
    }

    public void delete(int start){
        try{
            delete(start, ch.size());
        }catch(IndexIsNagetiveException | IndexOutOfRangeException e){
            System.out.println("突出一个错误");
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
            chTail[i] = ch.get(end + i);                //把end之后的尾巴保存起来
        }
        while(ch.size()>start){
            ch.remove(start);                           //将start前面的保留,start后面的全删除
        }
        for(int i=0; i<chTail.length; i++){
            ch.add(chTail[i]);                          //把end开始的尾巴加回去
        }
        
        if(start<0 || end <0){
            throw new IndexIsNagetiveException("删除的起始位置不能小于0");
        }
        if(start >= end){
            throw new IndexOutOfRangeException("删除的初始位置不能大于字符串长度也不能比末尾位置大");
        }            
    }

    public void reverse(){
        Object[] objCh = ch.toArray();
        for(int i=0; i<objCh.length/2; i++){
            Object temp = objCh[i];
            objCh[i] = objCh[objCh.length - i-1];
            objCh[objCh.length - i-1] = temp;
        }
        /*while(ch.size() != 0){                  //ch.size不为0一直删除，直到删空
            ch.remove(0);
        }*/
        ch.clear();                             //清空
        for(Object ob : objCh){
            ch.add((char)ob);                   //不传递类型只能转换为object数组
        }
    }

    public int length(){
        return ch.size();
    }

    public String toString(){
        return String.valueOf(ch);              //返回ArrayList的string形式,否则返回哈希值
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
        System.out.printf("MyStringBufferList耗时: %.2f\n", t6-t5);
    }
}