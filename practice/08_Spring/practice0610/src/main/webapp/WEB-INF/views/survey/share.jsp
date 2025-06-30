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
<h1>📢 ${survey.name}님의 설문에 참여해주세요!</h1>
<p><b>📝 한마디: </b>${survey.comment}</p>
<p>👇 아래 링크를 눌러 설문에 참여하세요:</p>
<p><a href="${survey.url}">${survey.url}</a></p>
<hr/>
<p>링크를 복사해서 공유하거나, 다른 친구들도 참여하도록 유도해보세요 🎉</p>
</body>
</html>
