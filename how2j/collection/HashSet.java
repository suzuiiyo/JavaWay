package collection;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable{
    public static void main(String[] args) {
    }
    //HshSet里面封装了一个HashMap
    private HashMap<E, Object> map;
    private static final Object PRESENT = new Object();
    //HashSet的构造方法初始化之歌HashMap
    public HashSet(){
        map = new HashMap<E, Object>();
    }

    //向HashSet中增加元素,其中就是把该元素作为key，增加到Map中
    //Value是PRESENT， 静态， final的对象，所有的HashSet都是用这么同一个对象
    public boolean add(E e){
        return map.put(e, PRESENT) == null;
    }

    //HashSet的Size就是Map的Size
    public int size(){
        return map.size();
    }

    //清空Set就是清空Map
    public void clear(){
        map.clear();
    }

    //迭代Set,就是把Map的键拿出来迭代
    public Iterator<E> iterator(){
        return map.keySet().iterator();
    }
}