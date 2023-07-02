<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_all.jsp" />

<section id="register_login_form">
  <h1>Đăng ký tài khoản</h1>
  <p>
    Để mà mua hàng hay thêm hàng vào giỏ thì bạn cần phải
    đăng ký một tài khoản để tiếp tục.<br>
    Bạn đã có tài khoản? <a href="<c:url value='/user_profile/login_user.jsp' />">Đăng nhập</a> ngay
  </p>
  
  <p><i>${message}</i></p>
  <form action="<c:url value='/userProfileController' />" method="post">
    <input type="hidden" name="action" value="register">
    
    <label>Tên đăng nhập*:</label>
    <input type="text" name="userName" value="${userInfo.userName}" required><br>
    <label>Email*:</label>
    <input type="email" name="email" value="${userInfo.email}" required><br>
    <label>Mật khẩu*:</label>
    <input type="password" name="password" value="${userInfo.password}" required><br>
    
    <label>Tên công ty:</label>
    <input type="text" name="companyName" value="${userInfo.companyName}"><br>
    <label>Địa chỉ*:</label>
    <input type="text" name="address" placeholder="Số nhà, Phường, Quận" value="${userInfo.address}"
      required><br>
    <label>Thành phố*:</label>
    <input type="text" name="city" value="${userInfo.city}" required><br>
    <label>Quốc gia:</label>
    <input type="text" name="country" value="${userInfo.country}"><br>

    <label>Loại thẻ tín dụng:</label>
    <input type="text" name="creditCardType" value="${userInfo.creditCardType}"><br>
    <label>Mã thẻ tín dụng:</label>
    <input type="text" name="creditCardNumber" value="${userInfo.creditCardNumber}"><br>
    <label>Ngày hết hạn:</label>
    <input type="text" name="creditCardExpirationDate" placeholder="Tháng/Năm (00/00)"
      value="${userInfo.creditCardExpirationDate}"><br>

    <label>&nbsp;</label>
    <button class="register_login_logout">Đăng ký</button>
  </form>
</section>

<jsp:include page="/includes/column_right_news.jsp" />
<jsp:include page="/includes/footer.jsp" />









