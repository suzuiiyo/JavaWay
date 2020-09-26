import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    //public void doGET(HttpServletRequest request, HttpServletResponse response){
    protected void service(HttpServletRequest request, HttpServletResponse response){
        System.out.println("获取单值参数name:" + request.getParameter("name"));

        //获取bobits的值存入数组
        String[] hobbies = request.getParameterValues("hobbies");
        System.out.println("获取具有多值的参数hobbies：" + Arrays.asList(hobbies));

        System.out.println("通过getParameterMap 遍历所有的参数: ");
        Map<String, String[]> parameters = request.getParameterMap();

        Set<String> paramNames = parameters.keySet();
        for(String param : paramNames){
            String[] value = parameters.get(param);
            System.out.println(param + "." + Arrays.asList(value));
        }
    }
}
