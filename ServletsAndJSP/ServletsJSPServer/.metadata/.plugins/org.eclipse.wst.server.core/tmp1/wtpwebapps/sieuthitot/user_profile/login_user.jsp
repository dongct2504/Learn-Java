<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_all.jsp" />

<section id="register_login_form">
  <h1>Đăng nhập tài khoản</h1>
  <p>
    Để mua hàng hay thêm hàng vào giỏ thì bạn cần phải
    đăng nhập để tiếp tục.<br>
    Bạn chưa có tài khoản? <a href="<c:url value='/user_profile/register_user.jsp' />">Đăng ký</a> ngay
  </p>

  <p><i>${message}</i></p>
  <form action="<c:url value='/userProfileController' />" method="post">
    <input type="hidden" name="action" value="login">
    
    <label>Email:</label>
    <input type="email" name="email" value="${email}" required><br>
    <label>Mật khẩu:</label>
    <input type="password" name="password" value="${password}" required><br>

    <label>&nbsp;</label>
    <button class="register_login_logout">Đăng nhập</button>
  </form>
</section>

<jsp:include page="/includes/column_right_news.jsp" />
<jsp:include page="/includes/footer.jsp" />









