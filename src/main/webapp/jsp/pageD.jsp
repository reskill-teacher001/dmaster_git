<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォワード処理</title>
</head>
<body>
<%
//String name = (String)session.getAttribute("NAME");
//Integer age = (Integer)application.getAttribute("AGE");
//String company = (String)request.getAttribute("COMPANY");
%>
●EL式<br>
名前：${NAME}<br>
年齢：${AGE}<br>
会社：${COMPANY}<br>
<hr>
ID:${USER.id}<br>
名前：${USER.name}<br>
年齢：${USER.age}<br>
</body>
</html>