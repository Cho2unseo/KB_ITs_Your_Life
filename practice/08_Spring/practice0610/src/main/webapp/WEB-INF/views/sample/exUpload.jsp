<%--
  Created by IntelliJ IDEA.
  User: eunseo
  Date: 6/11/25
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<form action="/sample/exUploadPost" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
    <div>
        <input type="file" name="files"/>
    </div>
    <div>
        <input type="file" name="files"/>
    </div>
    <div>
        <input type="file" name="files"/>
    </div>
    <div>
        <input type="file" name="files"/>
    </div>
    <div>
        <input type="file" name="files"/>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form>
</body>
</html>
