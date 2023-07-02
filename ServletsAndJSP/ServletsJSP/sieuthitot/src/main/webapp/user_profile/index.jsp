<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_all.jsp" />

<!-- start the middle column -->

<section>
  <h1>Hồ sơ của bạn</h1>

  <h2>Xin chào ${userInfo.userName} chúc bạn mua sắm vua vẻ</h2>
  <p>Email: ${userInfo.email}</p>
  <p>Địa chỉ nơi nhận hàng: ${userInfo.address}, ${userInfo.city}</p>

  <form action="<c:url value='/userProfileController' />">
    <input type="hidden" name="action" value="logout">
    <button class="register_login_logout">Đăng xuất</button>
  </form>
</section>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_news.jsp" />
<jsp:include page="/includes/footer.jsp" />




