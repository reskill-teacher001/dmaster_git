<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>占い</title>
</head>
<body>
	<h1>占いたい月を入力してね</h1>
	
	<form action="/dmaster/FortuneServlet" method="get">
		<select name="month">
			<c:forEach var="month" begin="1" end="12" step="1">
				<option value="${month}">${month}</option>
			</c:forEach>
		</select>
		月
		<input type="submit" value="占ってみる">
	</form>
</body>
</html>