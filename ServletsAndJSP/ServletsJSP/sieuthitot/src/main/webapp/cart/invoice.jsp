<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_all.jsp" />

<!-- start the middle column -->

<section>
	<h1>Hóa đơn của bạn</h1>

	<table>
		<tr>
			<th>Ngày</th>
			<td>${invoice.invoiceDateFormatted}</td>
			<td></td>
		</tr>
		<tr>
			<th class="top">Gửi đến địa chỉ</th>
			<td>${userInfo.addressHTMLFormat}</td>
			<td></td>
		</tr>
		<tr>
		  <th class="top">Người nhận</th>
		  <td>${userInfo.userName}</td>
		</tr>
		<tr>
			<td colspan="3"><hr></td>
		</tr>
		<tr>
			<th>Số lượng</th>
			<th>Sản phẩm</th>
			<th>Giá</th>
		</tr>

		<c:forEach var="item" items="${invoice.items}">
			<tr>
				<td>${item.quantity}</td>
				<td>${item.product.title}</td>
				<td>${item.totalFormatted}</td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="3"><hr></td>
		</tr>
		<tr>
			<th>Tổng cộng:</th>
			<td></td>
			<td>${invoice.invoiceTotalFormatted}</td>
		</tr>
	</table>

	<form action="<c:url value='/catalogController' />" method="post">
    <input type="hidden" name="action" value="completeOrder">
    <button class="continue_checkout">Xác nhận thanh toán</button>
	</form>
</section>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_news.jsp" />
<jsp:include page="/includes/footer.jsp" />





