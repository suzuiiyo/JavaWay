import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
			Date d = new Date();
			//DateFormat df = DateFormat.getDateInstance();
			//response.setContentType("test/html; charset=utf-8");
			response.setCharacterEncoding("GB2312");
			response.getWriter().println("<h1>下雨天，打雷啦，回家收衣服啦</h1>");
			//response.getWriter().println(new Date().toLocaleString());
			response.getWriter().println(form.format(d));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
	}
}
