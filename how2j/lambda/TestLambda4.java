package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TestLambda4 {
    public static void main(String[] args) {
        Supplier<List> s = new Supplier<List>(){       //匿名类， 返回值是一个容器ArrayList
            public List get(){
                return new ArrayList();
            }
        };
        //匿名类
        List list1 = getList(s);
        //Lambda表达式
        List list2 = getList(()->new ArrayList());
        //引用构造器
        List list3 = getList(ArrayList::new);            //用new构造实例化
    }

    public static List getList(Supplier<List> s){          // 过滤器接受匿名类作为参数, 返回一个List对象
        return s.get();
    }
}
