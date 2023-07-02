<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_all.jsp" />

<!-- start the middle column -->

<section>

	<h1>Thanh toán thành công</h1>
	<p>
    Cảm ơn ${userInfo.userName} đã mua sắm trên Siêu Thị Tốt.<br>
	</p>
	<p>
    Sản phẩm của bạn sẽ được giao trong vòng 2 ngày.
	</p>

</section>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_news.jsp" />
<jsp:include page="/includes/footer.jsp" />




