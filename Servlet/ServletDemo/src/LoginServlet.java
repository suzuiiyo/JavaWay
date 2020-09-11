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

        //×Ö·û´®·ÅÇ°ÃæÅĞ¶Ï·ÀÖ¹ÊäÈëÎª¿Õ µ¼ÖÂnullPointerÒì³£
        if("Å£±Æ".equals(name) && "123".equals(password))
            html = "<div style= 'color:green'>µÇÂ½³É¹¦</div>";
        else
            html = "<div style= 'color:red'>ÕË»§ÃÜÂë²»Æ¥Åä£¬µÇÂ½Ê§°Ü!</div>";

        response.setContentType("text/html; charset=GB2312");
        PrintWriter pw = response.getWriter();
        pw.println(html);
    }
}
