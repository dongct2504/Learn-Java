<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>Test SQL</title>
  <link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
  
  <c:if test="${sqlStatement == null}">
    <c:set var="sqlStatement" value="SELECT * FROM user_info"/>
  </c:if>

  <h1>The SQL gateway</h1>
  <p>
    Enter an sql statement and click Execute button.
  </p>

  <p><b>The SQL statement</b></p>
  <form action="sqlGateway" method="post">
    <textarea name="sqlStatement" cols="60" rows="8">${sqlStatement}</textarea><br>
    <input type="submit" value="Execute">
  </form>
  <p><b>SQL Result:</b></p>
  ${sqlResult}
  
</body>
</html>











