<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>${board} Reply</H1>
	<form action="${board}Reply" method="post">
		<input type="hidden" name="num" value="${boardDTO.num}">
		<input type="hidden" name="ref" value="${boardDTO.ref}">
		<input type="hidden" name="step" value="${boardDTO.step}">
		<input type="hidden" name="depth" value="${boardDTO.depth}">
		<input type="text" name="title">
		<input type="text" name="writer">
		<p><textarea name="contents"></textarea></p>
		<button>CLICK</button>
	</form>
</body>
</html>