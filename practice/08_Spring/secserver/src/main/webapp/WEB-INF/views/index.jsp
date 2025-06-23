<%--
  Created by IntelliJ IDEA.
  User: eunseo
  Date: 6/9/25
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>환영합니다.</h1>
<sec:authorize access="isAnonymous()">
    <a href="/security/login">로그인</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
<%--    로그인한 사용자만 볼 수 있는 영역--%>
    <sec:authentication property="principal.username"/>
    <%-- 로그아웃은 POST 방식으로 처리해야 CSRF 보호 가능--%>
    <form action="/security/logout" method="post">
            <%-- CSRF 공격 방지를 위한 토큰 전달--%>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="로그아웃">
    </form>
</sec:authorize>

</body>
</html>