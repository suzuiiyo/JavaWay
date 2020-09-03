package annotation;

public class NoBug {
    @checkFun
    public void arithmetic(){
        System.out.println("1234567890");
    }
    @checkFun
    public void add(){
        System.out.println("1+1="+1+1);
    }
    @checkFun
    public void minus(){
        System.out.println("1-1="+(1-1));
    }
    @checkFun
    public void plus(){
        System.out.println("3 x 5="+ 3*5);
    }
    @checkFun
    public void division(){
        System.out.println("6 / 0="+ 6 / 0);
    }


    public void introduce(){
        System.out.println("这个程序没有 bug");
    }
}
