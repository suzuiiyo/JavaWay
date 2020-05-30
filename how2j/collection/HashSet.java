package collection;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable{
    public static void main(String[] args) {
    }
    //HshSet�����װ��һ��HashMap
    private HashMap<E, Object> map;
    private static final Object PRESENT = new Object();
    //HashSet�Ĺ��췽����ʼ��֮��HashMap
    public HashSet(){
        map = new HashMap<E, Object>();
    }

    //��HashSet������Ԫ��,���о��ǰѸ�Ԫ����Ϊkey�����ӵ�Map��
    //Value��PRESENT�� ��̬�� final�Ķ������е�HashSet��������ôͬһ������
    public boolean add(E e){
        return map.put(e, PRESENT) == null;
    }

    //HashSet��Size����Map��Size
    public int size(){
        return map.size();
    }

    //���Set�������Map
    public void clear(){
        map.clear();
    }

    //����Set,���ǰ�Map�ļ��ó�������
    public Iterator<E> iterator(){
        return map.keySet().iterator();
    }
}