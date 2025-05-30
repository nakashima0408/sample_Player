<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>名前を入力</title>
</head>
<body>
	<h1>名前を入力してください</h1>
	<form action="JapamServlet" method="post">
		<input type = "text" name ="username" size = "40"/>
		<input type = "submit" value = "送信"/>
	</form> 
</body>
</html>