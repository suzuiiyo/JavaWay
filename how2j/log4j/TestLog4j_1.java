package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class TestLog4j_1 {
    static Logger logger = Logger.getLogger(TestLog4j.class);
    public static void main(String[] args) {
        //PropertyConfigurator��Ӧproperties�ļ��� DOMConfigurator��Ӧxml�ļ�
        DOMConfigurator.configure("d:\\Studio\\JavaWay\\how2j\\src\\log4j.xml");
        for(int i=0; i<5000; i++){
            logger.trace("������Ϣ");
            logger.debug("������Ϣ");
            logger.info("�����Ϣ");
            logger.warn("������Ϣ");
            logger.error("������Ϣ");
            logger.fatal("������Ϣ");
        }
    }
}
