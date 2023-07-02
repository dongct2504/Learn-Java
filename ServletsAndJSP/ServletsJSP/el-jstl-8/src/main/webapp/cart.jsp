<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>Xác nhận thanh toán</title>
  <link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
  <h1>Giỏ hàng của bạn</h1>
  <table>
    <tr>
      <th>Số lượng</th>
      <th>Mô tả</th>
      <th>Giá</th>
      <th>Tổng cộng</th>
    </tr>
    <c:forEach var="item" items="${cart.items}">
      <tr>
        <td>
          <form action="cart">
            <input type="hidden" name="action" value="cart">
            <input type="hidden" name="productCode" value="<c:out value="${item.product.code}"/>">
            <input type="text" name="quantity" value="<c:out value="${item.quantity}"/>" id="quantity">
            <input type="submit" value="Cập nhật">
          </form>
        </td>
        <td><c:out value="${item.product.description}"/></td>
        <td>${item.product.priceFormatted}</td>
        <td>${item.totalFormatted}</td>
				<td>
					<form action="cart">
            <input type="hidden" name="action" value="cart">
						<input type="hidden" name="productCode" value="<c:out value="${item.product.code}"/>">
						<input type="hidden" name="quantity" value="0">
						<input type="submit" value="Xóa">
					</form>
				</td>
      </tr>
    </c:forEach>
  </table>
  <p>
    <b>Tổng số tiền phải trả: ${cart.totalFormatted}</b>
  </p>
    
  <p>
    Để mà <i>thay đổi số lượng sản phẩm</i> thì bạn nhập số lượng như ý muốn rồi
    ấn vào nút <b>Cập nhật</b>.
  </p>
  
  <form action="cart">
    <input type="hidden" name="action" value="index">
    <input type="submit" value="Tiếp tục mua sắm">
  </form>
  
  <form action="cart">
    <input type="hidden" name="action" value="checkout">
    <input type="submit" value="Thanh toán">
  </form>
</body>
</html>







