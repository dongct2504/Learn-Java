<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<aside id="sidebarA">
  <nav>
    <ul>
      <li><a href="<c:url value='/' />">Trang chủ</a></li>
      <li><a href="<c:url value='/catalog' />">Sản phẩm</a></li>
      <c:choose>
        <c:when test="${userInfo == null}">
					<li><a href="<c:url value='/user_profile/login_user.jsp' />">Đăng nhập</a></li>
					<li><a href="<c:url value='/user_profile/register_user.jsp' />">Đăng ký</a></li>
        </c:when>
        <c:otherwise>
          <li><a href="<c:url value='/user_profile' />">${userInfo.userName}</a></li>
        </c:otherwise>
      </c:choose>
      <li><a href="<c:url value='/customer_service' />">Dịch vụ khách hàng</a></li>
    </ul>
  </nav>
</aside>







