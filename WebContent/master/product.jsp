<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品検索</title>

<link type="text/css" rel="stylesheet"
  href="http://code.jquery.com/ui/1.10.3/themes/cupertino/jquery-ui.min.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
<script src="../shopping/js/product.js"></script>

</head>
<body>
	<%@include file="../shopping/menu.jsp" %>
	<form action="Product.action" method="post" name="inform">
		<p>キーワード&ensp;&ensp;<input type="text" name="keyword"></p>
		<!--値段の値を表示する領域-->
		<p>価格&ensp;&ensp;<input id="num" type="text" name="price" size="3" readonly />円以下</p>
		<!--スライダーを表示する領域-->
		<div id="slider" style="width:300px; margin-bottom:12px;"></div>
		<input type="submit" value="検索">
		<input type="reset" value="キャンセル">
	<hr>
	<div id="result" style="color:red; font-weight:bold;">
		<p>${success}</p><p>${error}</p>
	</div>
	<table style="border-collapse:separate; border-spacing:10px;">
		<c:forEach var="product" items="${list}">
		<tr>
			<td>No.${product.id}</td>
			<td><img src="../shopping/image/${product.id}.jpg" height="64"></td>
			<td>${product.name}</td>
			<td>${product.price}円</td>
			<td><a href="EntryUpdProduct.action?id=${product.id}">変更</a></td>
		</tr>
		</c:forEach>
	</table>
		<input type="submit" value="検索リセット" onclick="return PushReset()">
	</form>
</body>
</html>