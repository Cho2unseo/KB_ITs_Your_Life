<%--
  Created by IntelliJ IDEA.
  User: eunseo
  Date: 6/23/25
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>login</h1>
<%--로그인 실패 시 전달되는 파라미터--%>
${param.error}
<form name="f" action="/security/login" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <c:if test="${param.error != null}">
        <div style="color: red">사용자 ID 또는 비밀번호가 틀립니다.</div>
    </c:if>
    <table>
        <tr>
            <td>User:</td>
            <td><input type="text" name="username" value=""></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"/> </td>
        </tr>
        <tr>
            <td colspan="2">
                <input name="submit" type="submit" value="Login"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
