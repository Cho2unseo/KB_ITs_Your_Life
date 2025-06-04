<%--
  Created by IntelliJ IDEA.
  User: eunseo
  Date: 6/4/25
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>scope 데이터 보기</h1>

pageScope의 속성값은 : ${pageScope.scopeName}<br>
requestScope의 속성값은 : ${requestScope.scopeName}<br>
sessionScope의 속성값은 : ${sessionScope.scopeName}<br>
applicationScope의 속성값은 : ${applicationScope.scopeName}<br>
<%--자동 범위 탐색: page->request->session->application 순서로 검색--%>
scopeName 자동 찾기 : ${scopeName}<br>
<%--Member 클래스에 getter가 있어야 내부 데이터에 접근 가능--%>
member: ${member.name}(${member.userid})<br>
</body>
</html>
