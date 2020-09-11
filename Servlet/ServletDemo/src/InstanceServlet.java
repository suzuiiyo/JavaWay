import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digit.Prime;



public class InstanceServlet extends HttpServlet {
    public InstanceServlet(){
        System.out.println("InstanceServlet 构造方法被调用");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //super.service(arg0, arg1);
        request.setCharacterEncoding("GB2312");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        String html = null;
        if("牛逼".equals(name) && "123".equals(password))
            html = "<div style= 'color:green' >登陆成功!</div>";
        else
            html = "<div style= 'color:red' >账户密码匹配不成功，登陆失败!</div>";

        response.setContentType("text/html; charset=GB2312");
        PrintWriter pw = response.getWriter();
        pw.println(html);
    }

    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        //super.init();
        System.out.println("init(ServletConfig");
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        //super.destroy();
        System.out.println("调用destroy()方法");
    }

    public static void main(String[] args) {
        
    }
}
