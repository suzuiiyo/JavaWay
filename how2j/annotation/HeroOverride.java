package annotation;

public class HeroOverride{
    String name;
    @Override
    public String toString(){
        return name;
    }
    //HeroAnno�ĸ��ಢû��fromString�������
    /*@Override
    public String fromString(){
        return name;
    }*/
}