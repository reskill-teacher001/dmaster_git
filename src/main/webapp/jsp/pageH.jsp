<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<%@ page import="java.util.Map, java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォワード処理</title>
</head>
<body>
<%
request.setAttribute("age", 23);
%>

<c:if test="${age >= 18}">
	成人<br>
</c:if>

<c:if test="${age < 18}">
	未成年<br>
</c:if>

<c:choose>
	<c:when test="${20 <= age && age < 30}">２０代</c:when>
	<c:when test="${30 <= age && age < 40}">３０代</c:when>
	<c:when test="${40 <= age && age < 50}">４０代</c:when>
	<c:otherwise>該当なし</c:otherwise>
</c:choose>

</body>
</html>