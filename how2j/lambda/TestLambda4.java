package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TestLambda4 {
    public static void main(String[] args) {
        Supplier<List> s =new Supplier<List>(){
            public List get(){
                return new ArrayList();
            }
        };
        //������
        List list1 = getList(s);
        //Lambda���ʽ
        List list2 = getList(()->new ArrayList());
        //���ù�����
        List list3 = getList(ArrayList::new);
    }

    public static List getList(Supplier<List> s){
        return s.get();
    }
}
