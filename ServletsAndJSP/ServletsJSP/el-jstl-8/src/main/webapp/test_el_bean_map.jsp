<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Test EL, JSTL for Java Bean and Map</title>
</head>
<body>
  <h1>Display Bean and Map</h1>

  <h2>Accesses the name, email property of the user attribute (bean)</h2>
  <!-- <p>Hello ${user.name}, your email is ${user.email}</p> -->
  <p>Hello <c:out value="${user.name}" />, your email is <c:out value="${user.email}" /></p>
  
  <h2>Accesses the D, T, N keys of the person attribute (map) to display values</h2>
  <!-- Hello ${person.D}, Hello ${person.T}, Hello ${person.N}</p> --><p>
  <p>Hello <c:out value="${person.D}" />, Hello <c:out value="${person.N}" /></p>
  
  <h2>Access list</h2>
  <!-- <p>Hello ${lists["0"]} and Hi ${lists[1]}</p> -->
  <p>Hello <c:out value="${lists[0]}" /> and Hi <c:out value="${lists[1]}" /> </p>
  
  <h2>Use forEach tag</h2>
  <c:forEach var="item" items="${lists}">
  	<p>This is: ${item}</p>
  </c:forEach>
</body>
</html>








