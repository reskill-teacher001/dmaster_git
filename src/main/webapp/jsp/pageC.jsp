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
String name = (String)session.getAttribute("NAME");
Integer age = (Integer)application.getAttribute("AGE");
String company = (String)request.getAttribute("COMPANY");
%>
●JSP<br>
名前：<%= name %><br>
年齢：<%= age %><br>
会社：<%= company %><br>

</body>
</html>