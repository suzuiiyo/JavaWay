<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" import="javax.servlet.http.Cookie"%>

<%
    Cookie c = new Cookie("name", "Gareen");
    Cookie a = new Cookie("age", "17");
    Cookie b = new Cookie("height", "178");
    c.setMaxAge(24 * 60 * 60);
    c.setPath("/");
    b.setPath("/");
    response.addCookie(c);
    response.addCookie(a);
    response.addCookie(b);
%>
<a href="getCookie.jsp">跳转到获取cookie的页面</a>