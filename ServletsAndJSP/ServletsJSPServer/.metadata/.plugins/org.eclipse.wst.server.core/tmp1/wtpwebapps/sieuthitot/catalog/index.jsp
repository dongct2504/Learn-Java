<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_all.jsp" />

<!-- start the middle column -->

<section>
  <h1>Những sản phẩm của Siêu Thị Tốt</h1>
  <c:forEach var="item" items="${products}">
		<div id="display_item" class="title_link">
		  <a href="<c:url value='/catalogController?action=showProduct&amp;productCode=${item.code}' />"> 
		    <img src="<c:url value='${item.imageURL}' />" alt="${item.title}" width="162">
		  </a>
		  <a href="<c:url value='/catalogController?action=showProduct&amp;productCode=${item.code}' />" 
		    class="no_underline">
		    ${item.title}
		  </a>
			<p class="price">${item.priceFormatted}</p>
		</div>
  </c:forEach> 
</section>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_news.jsp" />
<jsp:include page="/includes/footer.jsp" />





