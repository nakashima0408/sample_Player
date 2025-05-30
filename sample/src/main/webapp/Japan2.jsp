<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メッセージ</title>
</head>
<body>
	 <h2>メッセージ：</h2>
    <p>こんにちは<c:out value = "${ name }さん" /> </p>
    <a href="Japan1.jsp">戻る</a>
</body>
</html>