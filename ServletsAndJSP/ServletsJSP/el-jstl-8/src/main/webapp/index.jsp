<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>Mua nhạc</title>
  <link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
  <h1>Những album hay</h1>
  <form action="cart" class="right">
    <input type="hidden" name="action" value="cart">
    <c:out value="${cart.count}"/>
    <input type="submit" value="Giỏ hàng">
    <p>&nbsp;</p>
  </form>
  
  <table>
    <tr>
      <th>Tên album</th>
      <th>Giá</th>
      <th>&nbsp;</th>
      <th>&nbsp;</th>
    </tr>
    <c:forEach var="item" items="${products}">
      <tr>
        <td><c:out value="${item.description}"/></td>
        <td>${item.priceFormatted}</td>
        <td>
          <form action="cart">
            <input type="hidden" name="productCode" value="<c:out value="${item.code}"/>">
            <input type="submit" value="Thêm vào giỏ hàng">
          </form>
        </td>
        <td>
          <form action="cart">
            <input type="hidden" name="action" value="cart">
            <input type="hidden" name="productCode" value="<c:out value="${item.code}"/>">
            <input type="submit" value="Mua ngay">
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>











