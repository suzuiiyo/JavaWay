package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {

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

            req.setCharacterEncoding("utf-8");
            filterChain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }
}
