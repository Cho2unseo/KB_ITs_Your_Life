<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../layouts/header.jsp" %>

<h1 class="page-header my-4"><i class="fas fa-file-alt"></i> ${stock.stockName}</h1>

<div class="small-box">
    <p><b>종목 코드: </b>${stock.stockCode}</p>
    <p><b>현재가: </b><fmt:formatNumber value="${stock.price}" pattern="#,###"/>원</p>
    <p><b>등록일: </b><fmt:formatDate value="${stock.regDate}" pattern="yyyy-MM-dd"/></p>
    <p><b>설명: </b></p>
    <p>${stock.description}</p>
</div>

<div class="mt-4">
    <a href="list" class="btn btn-secondary"><i class="fas fa-list"></i> 목록</a>
    <form action="buy" method="post" class="d-inline">
        <input type="hidden" name="stockCode" value="${stock.stockCode}"/>
        <input type="hidden" name="stockName" value="${stock.stockName}"/>
        <input type="hidden" name="price" value="${stock.price}"/>
        <button type="submit" class="btn btn-success">
            <i class="fas fa-cart-plus"></i> 매수하기
        </button>
    </form>
</div>

<%@ include file="../layouts/footer.jsp" %>

