<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://unpkg.com/@coreui/coreui/dist/css/coreui.min.css">
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/@coreui/coreui/dist/js/coreui.min.js"></script>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
Tool for converting gathering website info or file to MYSQL
<br>
<form method="POST" action="/webupload" enctype="">
<label for="webinfo"> Enter website:</label><br>
<input type="text" id="webinfo" name="webinfo"><br>
<input type="submit" value="Submit" />
</form>
<br>
<form method="POST" action="/uploadfile" enctype="multipart/form-data">
  <label for="file">Enter file:</label><br>
  <input type="file" id="file" name="file"><br>
  <input type="submit" value="Submit" />
</form>

<br>
<br>
WebInfo List : <br>
<a href="/webinfolist">WebList</a><br>

Files List : <br>
<a href="/fileslist">Files List</a><br>

</body>
</html>