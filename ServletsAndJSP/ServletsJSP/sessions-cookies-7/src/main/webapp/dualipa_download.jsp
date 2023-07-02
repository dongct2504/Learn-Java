<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> <!-- To insert vietnamese character -->
<title>Download albums for Dua Lipa</title>
<link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
  <h1>Dua Lipa - Future Nostalgia</h1>
  <img src="resources/pictures/dualipa.png">

  <table>
    <tr>
      <th>Bài hát</th>
      <th>Nghe nhạc</th>
      <th>Tải nhạc</th>
    </tr>
    <tr>
      <td>Don't Start Now</td>
      <td>
        <audio controls>
          <source src="resources/sounds/dualipa/DontStartNow.mp3" type="audio/mpeg">
        </audio>
      </td>
      <td>
        <a href="resources/sounds/${productCode}/DontStartNow.mp3">MP3</a>
      </td>
    </tr>
  </table>
</body>
</html>