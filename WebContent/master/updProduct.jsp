<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報更新（管理者）</title>
</head>
<body>
	<%@include file="../shopping/menu.jsp" %>
	<form action="UpdateProduct.action" method="post" name="update">
		<input type="hidden"  name="id" value="${product.id}">
		<table style="border-collapse:separate; border-spacing:10px;">
			<tr>
				<td>No.${product.id}</td>
				<td><img src="../shopping/image/${product.id}.jpg" height="64"></td>
				<td><input type="text" name="name" value="${product.name}" required></td>
				<td><input type="text" name="price" value="${product.price}" required>円</td>
			</tr>
		</table>
		<input type="submit" value="更新">
	</form>
</body>
</html>