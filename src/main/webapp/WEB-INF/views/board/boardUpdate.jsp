<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>${board.toUpperCase()} Update</H1>
	<p>num : ${boardDTO.num}</p>
	<p>title : ${boardDTO.title}</p>
	<p>writer : ${boardDTO.writer}</p>
	<p>contents : ${boardDTO.contents}</p>
	<p>hit : ${boardDTO.hit}</p>
	
	<form action="${board}Update" method="post">
		<input type="hidden" name="num" value="${boardDTO.num}">
		<input type="text" name="title" value="${boardDTO.title}">
		<input type="text" name="writer" readonly="readonly" value="${boardDTO.writer}">
		<p><textarea name="contents">${boardDTO.contents}</textarea></p>
		<button>CLICK</button>
	</form>
</body>
</html>