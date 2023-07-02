<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>Siêu Thị Tốt - Website mua bán hàng đầu Việt Nam</title>
  <link rel="stylesheet" href="<c:url value='/styles/main.css' />" type="text/css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
</head>
<body>
  <header>
    <img src="<c:url value='/images/logo.jpg' />" alt="Logo for the website">
    <h1>Siêu Thị Tốt</h1>
    <h2>Siêu Thị Online hàng đầu dành cho người Việt</h2>
  </header>
  <nav id="nav_barA">
    <form action="searchItem">
      <input type="hidden" name="aciton" value="search">
      <input type="text" placeholder="Tìm kiếm trên Siêu Thị Tốt..." name="searchResult">
      
      <button><i class="fa fa-search"></i></button>
    </form>
  </nav>
  <nav id="nav_barB">
    <ul>
      <c:choose>
        <c:when test="${cart.count > 0}">
          <li><a href="<c:url value='/cart/' />" class="no_underline">Giỏ Hàng [${cart.count}]</a></li>
        </c:when>
        <c:otherwise>
          <li><a href="<c:url value='/cart/' />" class="no_underline">Giỏ Hàng</a></li>
        </c:otherwise>
      </c:choose>
      <li><a href="<c:url value='/admin/' />" class="no_underline">Admin</a></li>
    </ul>
  </nav>









