import java.util.ArrayList;

public class customGeneric extends ArrayList {
    public boolean add(Object o){
        if((o instanceof Integer) || (o instanceof Float)){
            super.add(o);
            return true;
        }else
            throw new IllegalArgumentException();
    }

    public void add(int pos, Object o){
        if((o instanceof Integer) || (o instanceof Float)){
            super.add(pos, o);
        }else 
            throw new IllegalArgumentException();
    }
    
    public static void main(String[] args) {
        customGeneric genList = new customGeneric();
        genList.add(1);
        genList.add(2.1f);
        genList.add(3.1415f);
        genList.add(22);
        System.out.println(genList);
    }
}