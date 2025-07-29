<%--
  Created by IntelliJ IDEA.
  User: eunseo
  Date: 6/16/25
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<nav class="navbar navbar-expand-md bg-primary navbar-dark sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><i class="fa-solid fa-house"></i> 홈</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <!-- 좌측 메뉴 구성 -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/stock/list">주식 목록</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/stock/buyList">매수한 종목 보기</a>
                </li>
            </ul>
            <!-- 우측 메뉴 -->
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <img src="https://randomuser.me/api/portraits/men/12.jpg"
                             class="avatar-sm"/>
                        admin
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fa-solid fa-right-from-bracket"></i> 로그아웃
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>