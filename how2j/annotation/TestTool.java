package annotation;

import java.lang.reflect.Method;

public class TestTool {
    public static void main(String[] args) {
        NoBug testobj = new NoBug();

        //反射取类对象
        Class clazz = testobj.getClass();
        //取类中声明的方法
        Method[] methods = clazz.getDeclaredMethods();
        //用来记录测试产生的Log信息
        StringBuilder log = new StringBuilder();
        //记录异常的次数
        int errornum = 0;
        //便利所有的类方法
        for(Method m : methods){
            //只有被@checkFun标注过的方法才进行测试
            //筛选出有标记(注解)的方法
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
                    //记录测试过程中，发生的异常的名字
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    //记录测试过程中，发生的异常的具体信息
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }

        log.append(clazz.getSimpleName());
        log.append(" has ");
        log.append(errornum);
        log.append(" error.");

        //生成测试报告
        System.out.println(log.toString());
    }
}
