package collection;
import java.lang.reflect.Array;
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
        if()
    }

    public void insert(int pos, char b){
        ch.get(pos);
    }

    public void insert(int pos, String str) throws IndexIsNagetiveException{
        if(pos<0){
            throw new IndexIsNagetiveException("pos��ֵ����С��0");
        }else{
            /*ArrayList<Character> chars = new ArrayList<>();         //��Stringת����ArrayList<Charater>
            for(char c : str.toCharArray()){
                chars.add(c);
            }*/
            char[] chars = str.toCharArray();
            char[] chTail = new char[ch.size()-pos];
            for(int i= pos; i<str.length(); i++){
                chTail[i] = ch.get(str.length() + i);      //��β���ϵ�char��������
                ch.remove(i);                               //ɾ��pos֮���suoyouԪ��
                ch.add(chars[i-pos]);                        //��chars�����charȫ����ӵ�ch��
                ch.add(chTail[ch.size()-i-chTail.length]);      //��λchTail�ĳ���
            }
        }
    }
}