import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("GB2312");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("name:" + name);
        System.out.println("password:" + password);

        String html = null;

        //�ַ�����ǰ���жϷ�ֹ����Ϊ�� ����nullPointer�쳣
        if("login".equals(name) && "123".equals(password))
            html = "<div style= 'color:green'>��½�ɹ�</div>";
        else
            html = "<div style= 'color:red'>�˻����벻ƥ�䣬��½ʧ��!</div>";

        response.setContentType("text/html; charset=GB2312");
        PrintWriter pw = response.getWriter();
        pw.println(html);
    }
}
