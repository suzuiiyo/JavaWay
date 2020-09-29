<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="javax.servlet.http.Cookie"%>

<%
    session.setAttribute("name", "jugg");
%>

<a href="getSession.jsp">跳转到获取session的页面</a>