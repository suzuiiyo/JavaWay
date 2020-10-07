package filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest servletReq, ServletResponse servletResp, FilterChain filterChain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
            HttpServletRequest req = (HttpServletRequest) servletReq;
            HttpServletResponse resp = (HttpServletResponse) servletResp;
            String ip = servletReq.getRemoteAddr();
            String url = req.getRequestURL().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH: hh:mm:ss");
            Date d = new Date();
            String date = sdf.format(d);

            System.out.printf("%s %s ทรฮสมห %s%n", date, ip, url);
            filterChain.doFilter(servletReq, servletResp);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("First Filter init()");
    }
}
