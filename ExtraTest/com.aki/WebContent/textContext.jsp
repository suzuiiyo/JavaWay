<%@ page language="java" contentType="text/html; character=utf-8" pageEncoding="utf-8" %>

<%
    application.setAttribute("test", 1);
    application.setAttribute("test", 2);
    application.removeAttribute("test");
%>