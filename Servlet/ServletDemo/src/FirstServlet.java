import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config){
        for(int i=0; i<100; i++)
            System.out.println("init of FirstServlet");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        //枚举已经逐渐被iterator取代, getHeaderNames返回的是一个Enumeration
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            String value = request.getHeader(header);
            System.out.printf("%s\t%s%n", header, value);
        }
        try{
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
            Date d = new Date();
            //response.setContentType("tset/html; charset=GB2312");
            response.setCharacterEncoding("GB2312");
            response.getWriter().println("<h1>部署一个Servlet</h1>");
            response.getWriter().println(form.format(d));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        
    }
}
