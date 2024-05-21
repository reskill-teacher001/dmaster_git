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
<h1>Step2</h1>

<div>スクリプトレットで繰り返し処理を利用しておみくじ</div>
<br>

<%
	Random rand = new Random();

	for (int month = 1; month <= 12; month++) {
		int num = rand.nextInt(6) + 1;

		String result;

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
		default:
			result = "吉";
			break;
		}
%>

<%= month %>月の運勢は、、、「<%= result %>」です。<br>

<%
	}
%>

</body>
</html>