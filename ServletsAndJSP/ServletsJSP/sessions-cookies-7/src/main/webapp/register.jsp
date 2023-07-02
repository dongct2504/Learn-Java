<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> <!-- To insert vietnamese character -->
  <title>Registration</title>
  <link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
  <h1>Download registration</h1>
  <p>
    Để mà tải nhạc hoặc nghe nhạc thì vui lòng đăng kí tài khoản, nhập tên
    và email sau đó nhấn vào nút Register.
  </p>
  
  <form action="download" method="post">
    <input type="hidden" name="action" value="registerUser">

    <label class="pad_top">Name:</label>
    <input type="text" name="name" value="${user.name}" required><br>

    <label class="pad_top">Email:</label>
    <input type="email" name="email" value="${user.email}" required><br>
    <label>&nbsp;</label>
    
    <input type="submit" value="Register" class="margin_left">
  </form>
</body>
</html>









