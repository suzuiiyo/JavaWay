import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HeroDAO;
import bean.Hero;

public class HeroListServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        List<Hero> heros = new HeroDAO().list();

        //整个一张表是个StringBuffer？
        StringBuffer sb = new StringBuffer();
        sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
        sb.append("<tr><td>id</td><td>name</td><td>hp</td><td>attack</td><td>delete</td></tr>\r\n");

        //通过id删除
        String trFormat = "<tr><td>%d</td><td>%s</td><td>%f</td><td>%f</td><td><a href='deleteHero?id=%d'>delete</a></td></tr>\r\n";

        for(Hero hero : heros){
            String tr = String.format(trFormat, hero.getId(), hero.getName(), hero.getHp(), hero.getAttack(), hero.getId());
            sb.append(tr);
        }
        sb.append("</table>");

        resp.getWriter().write(sb.toString());
    }
}
