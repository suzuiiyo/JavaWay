import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HeroDAO;
import bean.Hero;

public class HeroEdit2Servlet extends HttpServlet{
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Hero hero = new HeroDAO().get(id);
        req.setAttribute("hero", hero);
        req.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("editHero.jsp").forward(req, resp);
    }
}
