<%--
  Created by IntelliJ IDEA.
  User: eunseo
  Date: 6/11/25
  Time: 4:46 PM
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
<h1>🙌 나만의 설문 유도 페이지 만들기</h1>
<form action="/survey" method="post">
    <p>🙋‍♀️ 이름: <input type="text" name="name"><br/></p>
    <p>🔗 설문 링크: <input type="text" name="url"><br/></p>
    <p>📝 설문 참여를 유도하는 한 마디: <input type="text" name="comment" placeholder="예: 궁금하면 꼭 참여해줘!"><br/></p>
    <button type="submit">공유 페이지 생성</button>

</form>
</body>
</html>
