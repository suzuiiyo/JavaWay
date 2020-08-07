package annotation;

import java.util.ArrayList;
import java.util.List;

public class HeroSuppressWarnings {
    @SuppressWarnings({"rawtypes", "unused"})
    public static void main(String[] args) {
        List heros = new ArrayList();
    }
}