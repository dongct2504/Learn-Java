<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> <!-- To insert vietnamese character -->
  <title>View Cookies</title>
  <link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
  <h1>Cookies</h1>
  <p>
    Here's a table with all of the cookies that this browser is
    sending to the current server.
  </p>

  <table>
    <tr>
      <th>Name</th>
      <th>Value</th>
    </tr>
    <c:forEach var="c" items="${cookie}">
      <tr>
        <td>${c.value.name}</td>
        <td>${c.value.value}</td>
      </tr>
    </c:forEach>
  </table>
  
  <p>
    display the value for a cookie named userIdCookie<br>
    userIdCookie value: ${cookie.userIdCookie.value}
  </p>
  
  <h1>Other actions</h1>
  <p>
    <a href="download?action=viewAlbums">Xem albums</a>
  </p>
  <p>
    <a href="download?action=deleteCookies">Xóa hết persistent cookies</a>
  </p>
</body>
</html>









