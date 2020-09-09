import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
            Date d = new Date();
            //response.setContentType("tset/html; charset=GB2312");
            response.setCharacterEncoding("GB2312");
            response.getWriter().println("<h1>����һ��Servlet</h1>");
            response.getWriter().println(form.format(d));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
