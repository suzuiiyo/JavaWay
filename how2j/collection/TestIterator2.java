package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestIterator2 {
    public static void main(String[] args) {
        List<customDataType> l = new ArrayList<>();       //自定义的test数据类型
        System.out.println("初始化时l里的自定义数据的count的值: ");
        for(int i=0; i<3; i++){
            customDataType pi = new customDataType();
            l.add(pi);
            System.out.println(pi.kkk[0].count);
        }
        Iterator<customDataType> ite = l.iterator();
        System.out.println("用迭代器修改自定义数据的count的值: ");
        while(ite.hasNext()){
            customDataType a = ite.next();
            a.kkk[0].count = 2;
            System.out.println(a.kkk[0].count);
        }
        System.out.println("用迭代器修改之后l里自定义数据的count的值: ");
        for(customDataType b : l){
            System.out.println(b.kkk[0].count);                 //发生了变化,引用传递
        }

        System.out.println("**********************");

        List<String> list = Arrays.asList("java语言", "C语言", "C++语言");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            next = "修改后的";
            System.out.println(next);
        }
        System.out.println("用迭代器修改之后的list里的String数据的值: ");
        System.out.println(list);                               //没有发生变化,还是引用传递，只不过String不可改其内容，但是迭代器其实创建了新的String对象
    }
}