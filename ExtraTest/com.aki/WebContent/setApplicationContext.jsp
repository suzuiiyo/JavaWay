<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    application.setAttribute("name", "gareen");
    out.println(application == request.getServletContext());
    response.sendRedirect("getContext.jsp");
%>