package generic;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import log4j.TestLog4j2;

public class GenericExa2 {
    private static Logger logger = LogManager.getLogger(TestLog4j2.class.getName());
    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<>();
        List<Integer> integerArrayList = new ArrayList<>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            logger.debug("泛型测试", "类型相同");
        }
    }
}
