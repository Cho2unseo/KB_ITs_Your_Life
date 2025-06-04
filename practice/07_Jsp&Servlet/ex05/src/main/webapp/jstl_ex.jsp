<%--
  Created by IntelliJ IDEA.
  User: eunseo
  Date: 6/4/25
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSTL 테스트</h1>
<%--조건문: role 값이 "ADMIN"인지 확인--%>
<c:if test="${role == 'ADMIN'}">관리자</c:if>
<c:if test="${role != 'ADMIN'}">일반회원</c:if>

<table>
<%--    members 리스트 반복하며 member로 꺼내서 반복 상태를 state로 저장--%>
    <c:forEach var="member" items="${members}" varStatus="state">
        <tr>
<%--            현재 반복 인덱스 출력--%>
            <td>${state.index}</td>
            <td>${member.name}</td>
            <td>${member.userid}</td>
        </tr>
    </c:forEach>
</table>
<br>

<%--request scope 에 있는 Date 값 자동 찾기--%>
${today}<br>
<%--기본 날짜 형식 출력--%>
<fmt:formatDate value="${today}" type="date"/><br>
<fmt:formatDate value="${today}" type="time"/><br>
<fmt:formatDate value="${today}" type="both"/><br>
<%--dateStyle과 timeStyle 포함 출력--%>
<fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="long"/><br>
<fmt:formatDate value="${today}" type="both" dateStyle="long" timeStyle="short"/><br>
<%--커스텀 포맷 사용 (패턴 지정)--%>
<fmt:formatDate value="${today}" pattern="YYYY-MM-dd HH:mm:ss"/><br>
<fmt:formatDate value="${today}" pattern="YYYY-MM-dd a hh:mm:ss"/><br>
</body>
</html>
