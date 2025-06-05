<%--
  Created by IntelliJ IDEA.
  User: eunseo
  Date: 6/5/25
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Todo 목록 보기</h1>
<div>
    ${todoList}
    <a href="view">상세보기</a>
</div>
<div>
    <a href="create">새 Todo</a>
</div>
</body>
</html>
