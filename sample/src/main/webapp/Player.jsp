<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>プレイヤー一覧</title>
</head>
	<body>
		<div class = "container">
			<ul class = "list-group">
				<c:forEach var = "item" items = "${maps }">
					<li class = "list-group-item">${item.key }:${item.value }</li>
				</c:forEach>
			</ul>
		</div>
	</body>
</html>