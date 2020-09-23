import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HeroDAO;
import bean.Hero;

public class HeroUpdateServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        float hp = Float.parseFloat(req.getParameter("hp"));
        float attack = Float.parseFloat(req.getParameter("attack"));

        Hero hero = new Hero();
        hero.id = id;
        hero.setName(name);
        hero.setHp(hp);
        hero.setAttack(attack);

        System.out.println(hero.id + " " + hero.getName() + " " + hero.getHp() + " " + hero.getAttack());
        new HeroDAO().update(hero);

        resp.sendRedirect("/listHero");
    }
}
