<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> <!-- To insert vietnamese character -->
<title>Download albums for M-TP</title>
<link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
  <h1>Sơn Tùng M-TP</h1>
  <img src="resources/pictures/mtp.jpg">
  
  <table>
    <tr>
      <th>Bài hát</th>
      <th>Nghe nhạc</th>
      <th>Tải nhạc</th>
    </tr>
    <tr>
      <td>Âm Thầm Bên Em</td>
      <td>
        <audio controls>
          <source src="resources/sounds/mtp/AmThamBenEm.mp3">
        </audio>
      </td>
      <td>
        <a href="resources/sounds/${productCode}/AmThamBenEm.mp3">MP3</a>
      </td>
    </tr>
    <tr>
      <td>Chắc Ai Đó Sẽ Về</td>
      <td>
        <audio controls>
          <source src="resources/sounds/mtp/ChacAiDoSeVe.mp3">
        </audio>
      </td>
      <td>
        <a href="resources/sounds/${productCode}/ChacAiDoSeVe.mp3">MP3</a>
      </td>
    </tr>
    <tr>
      <td>Cơn Mưa Ngang Qua</td>
      <td>
        <audio controls>
          <source src="resources/sounds/mtp/ConMuaNgangQua.mp3">
        </audio>
      </td>
      <td>
        <a href="resources/sounds/${productCode}/ConMuaNgangQua.mp3">MP3</a>
      </td>
    </tr>
    <tr>
      <td>Không Phải Dạng Vừa Đâu</td>
      <td>
        <audio controls>
          <source src="resources/sounds/mtp/KhongPhaiDangVuaDau.mp3">
        </audio>
      </td>
      <td>
        <a href="resources/sounds/${productCode}/KhongPhaiDangVuaDau.mp3">MP3</a>
      </td>
    </tr>
    <tr>
      <td>Khuông Mặt Đáng Thương</td>
      <td>
        <audio controls>
          <source src="resources/sounds/mtp/KhuongMatDangThuong.mp3">
        </audio>
      </td>
      <td>
        <a href="resources/sounds/${productCode}/KhuongMatDangThuong.mp3">MP3</a>
      </td>
    </tr>
  </table>
</body>
</html>












