<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" import="javax.servlet.http.Cookie"%>
<%
    Cookie[] cookies = request.getCookies();
    if(null != cookies)
        for(int d=0; d<cookies.length; d++){
            out.print(cookies[d].getName() + ":" + cookies[d].getValue() + "<br>");
        }
%>