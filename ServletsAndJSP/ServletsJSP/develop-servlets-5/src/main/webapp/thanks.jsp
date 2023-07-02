<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Thanks</title>
  <link rel="stylesheet" href="styles/survey.css">
</head>
<body>
  <h1>thank you ${user.firstName} for joining our email list</h1>

  <p>Here is the information that you entered:</p>

  <label>Email:</label>
  <span>${user.email}</span>
  <br>
  <label>First Name:</label>
  <span>${user.firstName}</span>
  <br>
  <label>Last Name:</label>
  <span>${user.lastName}</span>
  <br>

  <p>To enter another email address, click on the Back button in
    your browser or the Return button shown below.</p>

  <form action="" method="post">
    <input type="hidden" name="action" value="join"> <input
      type="button" value="Return">
  </form>

</body>
</html>

