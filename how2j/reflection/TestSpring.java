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

        //���������ƻ�ȡ�����
        Class clazz = Class.forName(className);
        //���ݷ�������,��ȡ��������
        Method m = clazz.getMethod(methodName);
        //��ȡ������
        Constructor c = clazz.getConstructor();
        //���ݹ�����,ʵ����������
        Object service = c.newInstance();
        //���ö����ָ������
        m.invoke(service);
    }
}