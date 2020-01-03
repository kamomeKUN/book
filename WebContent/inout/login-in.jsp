<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<%@include file="../shopping/menu.jsp" %>
	<form action="Login.action" method="post">
		<!-- エラーメッセージがある場合は表示 -->
		<div id="error" style="color:red; font-weight:bold;">
			<c:out value="${message}"></c:out>
		</div>
		<p>ログインID</p><input type="text" name="login" value="">
		<p>パスワード</p><input type="text" name="password" value="">
		<p><input type="submit" value="ログイン"></p>
	</form>
</body>
</html>