import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HeroDAO;
import bean.Hero;

public class HeroEditServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        Hero hero = new HeroDAO().get(id);

        StringBuffer format = new StringBuffer();
        //resp.setContentType("text/html, charset=GB2312");
        //req.setCharacterEncoding("GB2312");

        format.append("<!DOCTYPE html>");
        format.append("<meta http-equiv='Content-Type' content='text/html; charset=GB2312'>");

        format.append("<form action='updateHero' method='post'>");
        format.append("名字: <input type='text' name='name' value='%s' ><br>");
        format.append("血量: <input type='text' name='hp' value='%f' ><br>");
        format.append("攻击: <input type='text' name='attack' value='%f' ><br>");
        format.append("<input type='hidden' name='id' value='%d'>");
        format.append("<input type='submit' value='更新'>");
        format.append("</form>");

        String html = String.format(format.toString(), hero.getName(), hero.getHp(), hero.getAttack(), hero.getId());
        resp.getWriter().write(html);
    }
}
