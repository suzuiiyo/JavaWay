package collection;

import java.util.LinkedList;
import charactor.Hero;

public class MyHashMap implements IHashMap{
    LinkedList<Entry>[] entrylist = new LinkedList[2000];
    public static void main(String[] args) {
        MyHashMap heroMap = new MyHashMap();
        Hero[] heroArr = new Hero[20];
        Object[] heroObj = new Object[20];
        for(int i=0; i<heroArr.length; i++){
            heroArr[i] = new Hero("hero" + i);
            heroArr[i].hp = i*i;
            heroObj[i] = heroArr[i];
            heroMap.put(heroArr[i].getName(), heroObj[i]);
        }

        System.out.println(heroMap.get("hero18"));
        System.out.println("\n\t***********************\n");
        System.out.println(heroMap);
    }

    public void put(String key, Object value){
        int[] strCode = new int[key.length()];                 
        for(int i=0; i<key.length(); i++){
            strCode[i] = CustomStringHashCode.hashcode(key);       //根据key生成hashcode   
            if(entrylist[strCode[i]]==null){                        //在entryList中根据hashCode定位对应位置是否有值
                Entry entry = new Entry(key, value);                //将字符串key和值value组成 键值对Entry
                LinkedList<Entry> codeList = new LinkedList<>();
                codeList.add(entry);
                entrylist[strCode[i]] = codeList;
            }else{
                Entry entry = new Entry(key, value);
                entrylist[strCode[i]].add(entry);
            }
        }
    }

    public Object get(String key){
        int[] strCode = new int[key.length()];
        Object obj =null;
        for(int i=0; i<key.length(); i++){
            strCode[i] = CustomStringHashCode.hashcode(key);
            if(entrylist[strCode[i]] == null){
                obj = null;
            }else{
                for(Entry e : entrylist[strCode[i]]){
                    if(e.key.equals(key)){
                        obj = e.value;
                    }else
                        obj = null;
                }
            }
        }
        return obj;
    }

    public String toString(){
        LinkedList<Entry> result = new LinkedList();
        for(LinkedList<Entry> linkedList : entrylist){
            if(linkedList == null){
                continue;
            }
            result.addAll(linkedList);
        }
        return result.toString();
    }
}