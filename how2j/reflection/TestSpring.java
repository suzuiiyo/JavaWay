package reflection;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestSpring {
    public static void main(String[] args) throws Exception {
        File f = new File("d:/Studio/JavaWay/AC/DC/spring.txt");
        Properties springConfig = new Properties();
        springConfig.load(new FileInputStream(f));
        String className = (String) springConfig.get("class");
        String methodName = (String) springConfig.get("method");

        //根据类名称获取类对象
        Class clazz = Class.forName(className);
        //根据方法名称,获取方法对象
        Method m = clazz.getMethod(methodName);
        //获取构造器
        Constructor c = clazz.getConstructor();
        //根据构造器,实例化出对象
        Object service = c.newInstance();
        //调用对象的指定方法
        m.invoke(service);
    }
}