import java.util.ArrayList;

public class TestGeneric3 {
    public static void main(String[] args) {
        ArrayList<Number> numlist = new ArrayList<>();
        numlist.add(112);
        numlist.add(112.123f);
        numlist.add(3.141592626535d);
        //ÎÞ·¨addString
        //numlist.add("numberical");

        System.out.println(numlist);
    }
}