<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>プレイヤー一覧</title>
<style>
	.top-right-btn {
		position: absolute;
		top: 20px;
		right: 20px;
	}
	
</style>
</head>
<body>
		
		<div class="container mt-4 position-relative">
		<a href="Player_Add.jsp" class="btn btn-primary top-right-btn">新規プレイヤー追加</a>
		<h2 class="mt-3">プレイヤー一覧</h2>
		<div class="table-container ">
		<table class="table table-striped table-bordered" style="width: auto;">
  			<thead class="table-dark">
    			<tr>
      				<th scope="col">country_id</th>
     				 <th scope="col">uniform_num</th>
     				 <th scope="col">position</th>
     				 <th scope="col">name</th>
     				 <th scope="col">club</th>
     				 <th scope="col">birth</th>
      				<th scope="col">height</th>
      				<th scope="col">weight</th>
   				 </tr>
  			</thead>
  		<tbody>
    			<c:forEach var="player" items="${players}">
					<tr>
						<td>${player.country_id}</td>
						<td>${player.uniform_num}</td>
						<td>${player.position}</td>
						<td>${player.name}</td>
						<td>${player.club}</td>
						<td>${player.birth}</td>
						<td>${player.height}</td>
						<td>${player.weight}</td>
					</tr>
				</c:forEach>
  				</tbody>
			</table>
		</div>		
	</div>
</body>
</html>