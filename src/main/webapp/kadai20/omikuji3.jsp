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
<h1>Step3</h1>

<%
//文字化け対策
request.setCharacterEncoding("UTF-8");

//リクエストパラメータを取得
String name = request.getParameter("name");
%>

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

<div>リクエストパラメータを取得しておみくじ結果を表示</div>
<br>
<%= name %>さんの今日の運勢は、、、「<%= result %>」です。
</body>
</html>