<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" import="java.util.*"%>
<div style="color: rgb(255, 230, 0); font-size:45px">前端很好玩</div>

<div style="color: rgb(255, 0, 0); font-size:80px">直接看效果</div>
<br>

<%
//<%@include file="footer.jsp" %>
<jsp:include page="footer.jsp">
    <jsp:param name="name" value="copyright" />
    <jsp:param name="year" value="2017" />
</jsp:include>
