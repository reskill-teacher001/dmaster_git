<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>英単語帳</title>
</head>
<body>
	<a href="/dmaster/kadai31add/registword.jsp">単語登録</a>
	<a href="/dmaster/kadai31add/searchword.jsp">単語検索</a>
	<hr>

	<form action="/dmaster/word" method="get">
		<input type="hidden" name="action" value="search">
		
		キーワード：<input type="text" name="keyword"><br>
		<input type="submit" value="検索">		
	</form>
</body>
</html>