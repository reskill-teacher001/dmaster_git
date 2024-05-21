<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おみくじ</title>
</head>
<body>
<h1>Step1</h1>

<%
	Random rand = new Random();
	int num = rand.nextInt(6) + 1;
	
	String result = "吉";
	
	switch (num) {
	case 1:
		result = "大吉";
		break;
	case 2:
		result = "小吉";
		break;
	case 3:
		result = "凶";
		break;
	}

%>

<div>スクリプトレットを使用しておみくじ</div>
<br>
今日の運勢は、、、「<%= result %>」です。
</body>
</html>