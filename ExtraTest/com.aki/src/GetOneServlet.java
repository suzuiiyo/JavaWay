import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import net.sf.json.JSONObject;

public class GetOneServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        Hero hero = new Hero();
        hero.setName("°ËË¹°Í");
        hero.setHp(456f);

        JSONObject json = new JSONObject();

        json.put("hero", JSONObject.fromObject(hero));
        resp.setContentType("text/html, charset=GBK");
        resp.getWriter().print(json);
    }
}
