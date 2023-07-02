<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> <!-- To insert vietnamese character -->
<title>Download albums for Ariana Grande</title>
<link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
  <h1>Ariana Grande - My Everything</h1>
  <img src="resources/pictures/ArianaGrande.png">
  
  <table>
    <tr>
      <th>Bài hát</th>
      <th>Nghe nhạc</th>
      <th>Tải nhạc</th>
    </tr>
    <tr>
      <td>7 Rings</td>
      <td>
        <audio controls>
          <source src="resources/sounds/ag/7rings.mp3" type="audio/mpeg">
        </audio>
      </td>
      <td>
        <a href="resources/sounds/${productCode}/7rings.mp3">MP3</a>
      </td>
    </tr>
    <tr>
      <td>One Last Time</td>
      <td>
        <audio controls>
          <source src="resources/sounds/ag/OneLastTime.mp3" type="audio/mpeg">
        </audio>
      </td>
      <td>
        <a href="resources/sounds/${productCode}/OneLastTime.mp3">MP3</a>
      </td>
    </tr>
    <tr>
      <td>POV</td>
      <td>
        <audio controls>
          <source src="resources/sounds/ag/pov.mp3" type="audio/mpeg">
        </audio>
      </td>
      <td>
        <a href="resources/sounds/${productCode}/pov.mp3">MP3</a>
      </td>
    </tr>
    <tr>
      <td>Problem</td>
      <td>
        <audio controls>
          <source src="resources/sounds/ag/Problem.mp3" type="audio/mpeg">
        </audio>
      </td>
      <td>
        <a href="resources/sounds/${productCode}/Problem.mp3">MP3</a>
      </td>
    </tr>
    <tr>
      <td>Thank U Next</td>
      <td>
        <audio controls>
          <source src="resources/sounds/ag/thankUnext.mp3" type="audio/mpeg">
        </audio>
      </td>
      <td>
        <a href="resources/sounds/${productCode}/thankUnext.mp3">MP3</a>
      </td>
    </tr>
  </table>
</body>
</html>






