import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HeroDAO;
import bean.Hero;
import net.sf.json.JSONSerializer;

public class GetManyServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Hero> heros = new ArrayList<>();
        heros = new HeroDAO().list(1, 10);

        String result = JSONSerializer.toJSON(heros).toString();

        resp.setContentType("text/html; charset=GBK");
        resp.getWriter().println(result);
    }
}
