package annotation;

import java.lang.reflect.Method;

public class TestTool {
    public static void main(String[] args) {
        NoBug testobj = new NoBug();

        //����ȡ�����
        Class clazz = testobj.getClass();
        //ȡ���������ķ���
        Method[] methods = clazz.getDeclaredMethods();
        //������¼���Բ�����Log��Ϣ
        StringBuilder log = new StringBuilder();
        //��¼�쳣�Ĵ���
        int errornum = 0;
        //�������е��෽��
        for(Method m : methods){
            //ֻ�б�@checkFun��ע���ķ����Ž��в���
            //ɸѡ���б��(ע��)�ķ���
            if(m.isAnnotationPresent(checkFun.class)){
                try{
                    m.setAccessible(true);
                    m.invoke(testobj, null);

                }catch(Exception e){
                    errornum++;
                    log.append(m.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n\r caused by ");
                    //��¼���Թ����У��������쳣������
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    //��¼���Թ����У��������쳣�ľ�����Ϣ
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }

        log.append(clazz.getSimpleName());
        log.append(" has ");
        log.append(errornum);
        log.append(" error.");

        //���ɲ��Ա���
        System.out.println(log.toString());
    }
}
