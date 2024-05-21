<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キヤノン社員名簿</title>
</head>
<body>
	<h1>キヤノン社員一覧</h1>
	<hr>
	
	<table border="1">
		<tr>
			<th>ID</th><th>名前</th><th>年齢</th>
		</tr>
		
		<c:forEach var="user" items="${list}">
			<tr>
				<td>${user.id}</td><td>${user.name}</td><td>${user.age}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="/dmaster/control?action=insert">新規登録</a>
</body>
</html>