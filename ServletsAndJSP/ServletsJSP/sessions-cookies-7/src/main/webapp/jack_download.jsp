<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> <!-- To insert vietnamese character -->
<title>Download albums for Jack</title>
<link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
  <h1>Jack KICM - Các đĩa nhạc</h1>
  <img src="resources/pictures/jack.jpg">
  
  <table>
    <tr>
      <th>Bài hát</th>
      <th>Nghe nhạc</th>
      <th>Tải nhạc</th>
    </tr>
    <tr>
      <td>Bạc Phận</td>
      <td>
        <audio controls>
          <source src="resources/sounds/jack/BacPhan.mp3">
        </audio>
      </td>
      <td>
        <a href="resources/sounds/${productCode}/BacPhan.mp3">MP3</a>
      </td>
    </tr>
    <tr>
      <td>Hồng Nhan</td>
      <td>
        <audio controls>
          <source src="resources/sounds/jack/HongNhan.mp3">
        </audio>
      </td>
      <td>
        <a href="resources/sounds/${productCode}/HongNhan.mp3">MP3</a>
      </td>
    </tr>
    <tr>
      <td>Sóng Gió</td>
      <td>
        <audio controls>
          <source src="resources/sounds/jack/SongGio.mp3">
        </audio>
      </td>
      <td>
        <a href="resources/sounds/${productCode}/SongGio.mp3">MP3</a>
      </td>
    </tr>
  </table>
</body>
</html>











