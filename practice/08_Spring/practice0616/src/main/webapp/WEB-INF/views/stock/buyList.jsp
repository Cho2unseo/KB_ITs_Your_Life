<%--
  Created by IntelliJ IDEA.
  User: eunseo
  Date: 6/16/25
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../layouts/header.jsp"%>

<h1 class="page-header my-4"><i class="fas fa-list"></i> 매수한 종목</h1>
<table class="table table-hover">
    <thead>
    <tr>
        <th>종목 코드</th>
        <th style="width: 130px">종목 이름</th>
        <th style="width: 100px">매수가</th>
        <th style="width: 100px">매수일</th>
        <th style="width: 100px">매도</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="buy" items="${list}">
        <tr>
            <td>${buy.stockCode}</td>
            <td>${buy.stockName}</td>
            <td>
                <fmt:formatNumber value="${buy.price}" pattern="#,###" />원
            </td>
            <td>${buy.buyDate}</td>
            <td>
                <form action="sell" method="post">
                    <input type="hidden" name="id" value="${buy.id}"/>
                    <button type="submit" class="btn btn-danger btn-sm">
                        <i class="fa-solid fa-right-left"></i> 매도
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="text-end">
    <a href="create" class="btn btn-primary">
        <i class="far fa-edit"></i>새 종목 등록
    </a>
</div>

<%@ include file="../layouts/footer.jsp"%>
