<%--
  Created by IntelliJ IDEA.
  User: eunseo
  Date: 6/4/25
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>🍪 우리 반 인기 간식 투표</h1>
<form action="/vote-submit" method="post">
    <fieldset>
        <legend>좋아하는 간식을 하나 골라주세요</legend>
        <input type="radio" name="snack" value="와사비과자">와사비과자<br/>
        <input type="radio" name="snack" value="붕어빵">붕어빵<br/>
        <input type="radio" name="snack" value="쿠쉬쿠쉬">쿠쉬쿠쉬<br/>
        <input type="radio" name="snack" value="초코하임">초코하임<br/>
        <input type="radio" name="snack" value="몽쉘">몽쉘<br/>
        <input type="radio" name="snack" value="커스타드">커스타드<br>
        <input type="radio" name="snack" value="쿠크다스">쿠크다스<br>
        <input type="radio" name="snack" value="초코파이">초코파이<br/>
        <input type="radio" name="snack" value="꿀꽈배기">꿀꽈배기<br>
        <br/>
        <button type="submit">투표하기</button>
    </fieldset>
</form>
</body>
</html>
