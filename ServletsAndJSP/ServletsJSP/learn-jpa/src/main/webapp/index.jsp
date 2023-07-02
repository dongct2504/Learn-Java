<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Email list</title>
  <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
  <h1>Join our email list</h1>
  <p>
    To join our email list, enter your name and email address below.
  </p>
  <p><i>${message}</i></p>
  <form action="emailList" method="post">
    <input type="hidden" name="action" value="add">        

    <label class="pad_top">Name:</label>
    <input type="text" name="name" value="${user.name}" required><br>
    <label class="pad_top">Email:</label>
    <input type="email" name="email" value="${user.email}" required><br>

    <label>&nbsp;</label>
    <input type="submit" value="Join Now" class="margin_left">
  </form>
</body>
</html>







