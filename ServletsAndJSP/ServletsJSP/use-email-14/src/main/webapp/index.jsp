<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>Hello</title>
  <link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
  <h1>Enter your email</h1>
  
  <form action="email" method="post">
    <input type="hidden" name="action" value="add">
    
    <label>Name:</label>
    <input type="text" name="name" required><br>
    <label>Email:</label>
    <input type="email" name="email" required><br>
    
    <label>&nbsp;</label>
    <input type="submit" value="Join Now" class="margin_left">
  </form>
  
  <h1>Access admin page</h1>
  <p>
    Click <a href="admin/test.html">here</a> to access admin page
  </p>
</body>
</html>






