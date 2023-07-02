<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_all.jsp" />

<!-- start the middle column -->

<section>
  <img src="<c:url value='${product.imageURL}' />" alt="Product image" width="298">
  <h1>${product.title}</h1>
  <p>${product.type}</p>
	<h1 class="price">${product.priceFormatted}</h1>
	<div id="module_add_cart">
    <form action="<c:url value='/catalogController' />">
      <input type="hidden" name="action" value="addToCart">
      <input type="hidden" name="productCode" value="${product.code}">
      <button class="button_style">Thêm vào giỏ hàng</button>
    </form>
    <form action="<c:url value='/catalogController' />">
      <input type="hidden" name="action" value="buy">
      <input type="hidden" name="productCode" value="${product.code}">
      <button class="button_style">Mua ngay</button>
    </form>
	</div>
  <div class="description">
    <h2>Mô tả</h2>
		<p>${product.description}</p>
  </div>
</section>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_news.jsp" />
<jsp:include page="/includes/footer.jsp" />







