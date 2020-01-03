<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト</title>
</head>
<body>
	<!-- エラーメッセージがある場合は表示 -->
	<div id="error" style="color:red; font-weight:bold;">
		<c:out value="${message}"></c:out>
	</div>
	<p>ログアウトしますか？</p>
	<p><a href="Logout.action">ログアウト</a></p>
</body>
</html>