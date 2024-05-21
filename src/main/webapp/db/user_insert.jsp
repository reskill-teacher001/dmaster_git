<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キヤノン社員名簿</title>
</head>
<body>
	<h1>社員登録</h1>
	<hr>

	<form action="/dmaster/control" method="post">
		<input type="hidden" name="action" value="insert_exec">
		
		ID:<input type="text" name="id"><br>
		名前:<input type="text" name="name"><br>
		年齢:<input type="text" name="age"><br>
		<br>
		<input type="submit" value="登録">
	</form>
</body>
</html>