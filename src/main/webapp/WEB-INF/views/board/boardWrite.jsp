<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>${board.toUpperCase()} Write</H1>
	<form action="${board}Write" method="post">
		<input type="hidden" name="num" value="1">
		<input type="hidden" name="hit" value="0">
		<input type="text" name="title">
		<input type="text" name="writer">
		<p><textarea name="contents"></textarea></p>
		<button>CLICK</button>
	</form>
</body>
</html>