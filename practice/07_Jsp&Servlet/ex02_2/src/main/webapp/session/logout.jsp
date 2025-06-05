<%--
  Created by IntelliJ IDEA.
  User: eunseo
  Date: 5/29/25
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 세션 무효화(세션 데이터 제거)
    session.invalidate();
    response.sendRedirect("loginForm.html");
%>