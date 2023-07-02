<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_all.jsp" />

<!-- start the middle column -->

<section id="cart">
	<h1>Giỏ hàng của bạn</h1>
	<c:choose>
		<c:when test="${cart.count > 0}">
			<table>
				<tr>
					<th>Sản phẩm</th>
					<th>Miêu tả</th>
				</tr>
				<tr>
					<td colspan="3"><hr></td>
				</tr>
				<c:forEach var="item" items="${cart.items}">
					<tr class="cart_row">
            <td>
              <a href="<c:url 
                  value='/catalogController?action=showProduct&amp;productCode=${item.product.code}' />">
                <img src="<c:url value='${item.product.imageURL}' />" width="146">
              </a>
            </td>
						<td>
						  <!-- Product description -->
						  <p><b>Tên sản phẩm:</b> ${item.product.title}</p>
							<!-- Product price -->
						  <p><b>Giá:</b> ${item.product.priceFormatted}</p>
							<!-- Product quantity -->
							<form action="<c:url value='/catalogController'/>" method="post">
								<input type="hidden" name="action" value="updateItem"> 
								<input type="hidden" name="productCode" value="<c:out value='${item.product.code}'/>"> 

                <label>Số lượng:</label>
								<input type="text" name="quantity" value="<c:out value='${item.quantity}'/>" class="quantity">
                <button>Cập nhật</button>
							</form>
						  <!-- Product total price -->
						  <p><b>Tổng:</b> ${item.totalFormatted}</p>
							<!-- The remove button -->
							<form action="<c:url value='/catalogController'/>" method="post">
                <input type="hidden" name="action" value="removeItem">
								<input type="hidden" name="productCode" value="<c:out value='${item.product.code}'/>"> 
								<button>Xóa</button>
							</form>
						</td>
					</tr>
					<tr>
						<td colspan="3"><hr></td>
					</tr>
				</c:forEach>
			</table>

			<p>Để thay đổi số lượng, vui lòng ấn vào nút <b>Cập nhật</b>.</p>
			<p>Để xóa một sản phẩm, vui lòng ấn vào nút <b>Xóa</b>.</p>
		</c:when>
		<c:otherwise>
			<p>Giỏ hàng của bạn đang rỗng.</p>
		</c:otherwise>
	</c:choose>

	<form action="<c:url value='/catalog/' />">
		<button class="continue_checkout">Tiếp tục mua sắm</button>
	</form>

	<c:if test="${cart.count > 0}">
		<!-- Connection is NOT SECURE.  For testing only. -->
		<form action="<c:url value='/catalogController' />" method="post">
		  <input type="hidden" name="action" value="checkout">
		  <button class="continue_checkout">Thanh toán</button>
		</form>
		<!-- Connection is SECURE.  Before you can use it, you need to configure 
    a secure connection on your system as described in chapter 15, comment
    out the previous form, and remove the comments from the following form. -->
		<!--
    <form action="${absolutePathSecure}/order/checkUser" method="post">
      <input type="submit" value="Checkout">
    </form>
    -->
	</c:if>
</section>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_news.jsp" />
<jsp:include page="/includes/footer.jsp" />






