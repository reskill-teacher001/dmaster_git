<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板</title>
</head>
<body>
<%
//文字化け対策
request.setCharacterEncoding("UTF-8");

//送信データを取得
String name = request.getParameter("NAME");
String message = request.getParameter("MESSAGE");

@SuppressWarnings("unchecked")
List<String> list = (List<String>)session.getAttribute("list");

if (list == null) {
	list = new ArrayList<>();
	session.setAttribute("list", list);
}

if (name != null && message != null) {
	list.add(name + "：" + message);
}
%>

<form action="bbs.jsp" method="post">
	名前：<br>
	<input type="text" name="NAME">
	<br>
	メッセージ：<br>
	<textarea name="MESSAGE" cols="30" rows="5"></textarea>
	<br>
	<input type="submit" value="書き込み">
</form>

<hr>

<%
for (String msg : list) {
%>
	<%= msg %>
	<hr>
<%
}
%>
</body>
</html>