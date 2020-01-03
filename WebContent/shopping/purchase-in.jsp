<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入確認画面</title>
</head>
<body>
	<%@include file="menu.jsp" %>

	<p>${cart.size()}種類の商品があります。</p>
	<table style="border-collapse:separate; border-spacing:10px;">
		<c:forEach var="item" items="${cart}">
		<tr>
			<td>No.${item.product.id}</td>
			<td><img src="image/${item.product.id}.jpg" height="64"></td>
			<td>${item.product.name}</td>
			<td>${item.product.price}円</td>
			<td>${item.count}個</td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	<div id="error" style="color:red; font-weight:bold;">
		<c:out value="${error}"></c:out>
	</div>
	<form action="Purchase.action" method="post">
		<p>お名前&ensp;<input type="text" name="name" value=""></p>
		<p>ご住所&ensp;<input type="text" name="address" value=""></p>
		<input type="submit" value="購入確定">
	</form>
</body>
</html>