<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Thanks bro, appreciate it</title>
  <link rel="stylesheet" href="styles/main.css" type="text/css" />
</head>

<body>
  <h1>Thanks for joining our email list</h1>

  <p>Here is the information that you entered:</p>

  <label>Name:</label>
  <span>${user.name}</span><br>
  <label>Email:</label>
  <span>${user.email}</span><br>
  
  <h1>Here are all users</h1>
  <table>
    <tr>
      <th>Name</th>
      <th>Email</th>
    </tr>
    <c:forEach var="item" items="${users}">
      <tr>
        <td><c:out value="${item.name}" /></td>
        <td><c:out value="${item.email}" /></td>
      </tr>
    </c:forEach>
  </table>

  <p>To enter another email address, click on the Back button in
    your browser or the Return button shown below.</p>

  <form action="" method="post">
    <input type="hidden" name="action" value="join"> 
    <input type="submit" value="Return">
  </form>
</body>
</html>







