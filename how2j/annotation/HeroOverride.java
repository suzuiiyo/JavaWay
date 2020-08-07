package annotation;

public class HeroOverride{
    String name;
    @Override
    public String toString(){
        return name;
    }
    //HeroAnno的父类并没有fromString这个方法
    /*@Override
    public String fromString(){
        return name;
    }*/
}