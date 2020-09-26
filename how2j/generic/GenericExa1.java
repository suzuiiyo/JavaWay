package generic;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import log4j.TestLog4j2;



public class GenericExa1 {
    private static Logger logger = LogManager.getLogger(TestLog4j2.class.getName());
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        arrayList.add("aaa");
        arrayList.add(100);

        for (int i = 0; i < arrayList.size(); i++) {
            String item = (String) arrayList.get(i);
            //logger.debug("·ºÐÍ²âÊÔ", "item = " + item);
        }
    }
}
