<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>初めてのJSP</title>
</head>
<body>
<%-- 宣言 --%>
<%!
public int tasu(int x, int y) {
	return x + y;
}
%>

<%-- スクリプトレット（Javaのプログラムを書く領域１ --%>
<!-- スクリプトレット（Javaのプログラムを書く領域２ -->
<%
//名前を表示
//for (int i = 1; i <= 5; i++) {
//	out.println("山田太郎" + "<br>");
//}

String name = "山田太郎";
%>

私の名前は<%= name %>です。<br>
加算結果：<%= tasu(10, 20) %><br>

</body>
</html>