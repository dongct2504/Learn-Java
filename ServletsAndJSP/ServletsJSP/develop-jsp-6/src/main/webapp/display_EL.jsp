<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <c:import url="/includes/header.html" /> -->
<%@ include file="/includes/header.html"%>

<h1>Testing Expression Language</h1>

<h2>Display the current year</h2>
<p>The current year is: ${currentYear}</p>

<h2>Display property of an attribute</h2>
<p>User's name is: ${user.firstName} ${user.lastName}</p>
<p>User's email is: ${user.email}</p>

<h2>
  Display an JSTL <i>if</i> tag to check message
</h2>
<c:if test="${message != null}">
  <p>
    <i>${message}</i>
  </p>
</c:if>

<h2>
  Display an JSTL <i>if</i> tag to test for a String value
</h2>
<c:if test="${user.email != null}">
  <p>
    This is an email: <i>${user.email}</i>
  </p>
</c:if>

<!-- <c:import url="/includes/footer.jsp" /> -->
<%@ include file="/includes/footer.jsp"%>
