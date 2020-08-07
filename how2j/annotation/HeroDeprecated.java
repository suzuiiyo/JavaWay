package annotation;

public class HeroDeprecated {
    String name;

    @Deprecated
    public void hackMap(){

    }

    public static void main(String[] args){
        new HeroDeprecated().hackMap();
    }
}