<%--
  Created by IntelliJ IDEA.
  User: eunseo
  Date: 5/29/25
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h1>로그인 정보 세션 저장</h1>
<%
    // 사용자가 보낸 id 값 꺼내기
    String id = request.getParameter("userid");
    if (id == null) {
        // 아이디가 없으면 다시 로그인 폼으로 이동
        response.sendRedirect("loginForm.html");
    } else {
        String pw = request.getParameter("password");
        // 세션에 로그인 정보 저장
        session.setAttribute("userid", id);
        session.setAttribute("password", pw);
        out.print("안녕하세요 " + id + "<br>");
        out.print("<a href='loginInfo.jsp'>정보보기</a>");
    }
%>
</body>