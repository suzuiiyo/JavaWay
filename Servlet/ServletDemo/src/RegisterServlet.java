import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    //public void doGET(HttpServletRequest request, HttpServletResponse response){
    protected void service(HttpServletRequest request, HttpServletResponse response){
        System.out.println("��ȡ��ֵ����name:" + request.getParameter("name"));

        //��ȡbobits��ֵ��������
        String[] hobbies = request.getParameterValues("hobbies");
        System.out.println("��ȡ���ж�ֵ�Ĳ���hobbies��" + Arrays.asList(hobbies));

        System.out.println("ͨ��getParameterMap �������еĲ���: ");
        Map<String, String[]> parameters = request.getParameterMap();

        Set<String> paramNames = parameters.keySet();
        for(String param : paramNames){
            String[] value = parameters.get(param);
            System.out.println(param + "." + Arrays.asList(value));
        }
    }
}
