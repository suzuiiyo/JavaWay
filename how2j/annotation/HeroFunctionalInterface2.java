package annotation;

@FunctionalInterface
public interface HeroFunctionalInterface2 {
    //有两个抽象方法， 无法被标记为函数式接口
    public void apAttack();
    //public void apAttack2();
}