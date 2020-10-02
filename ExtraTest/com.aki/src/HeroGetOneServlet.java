import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HeroDAO;
import bean.Hero;

public class HeroGetOneServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Random rand = new Random();
        int i = (rand.nextInt(1 + 99) + 1);
        Hero hero = new HeroDAO().get(i);
        String heroStr = hero.toString();
        resp.getWriter().print(heroStr);
    }
}
