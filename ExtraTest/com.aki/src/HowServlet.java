import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HowServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date d = new Date();
        String html = "<div style='color :  green'>How can I save my life?</div>";
        resp.setCharacterEncoding("GBK");
        resp.getWriter().println(html);;
        resp.getWriter().println(sdf.format(d));
    }
}
