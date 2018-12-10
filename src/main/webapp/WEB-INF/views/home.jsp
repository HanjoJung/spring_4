<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<p>
		<a href="./notice/noticeList">notice</a>
	</p>
	<p>
		<a href="./qna/qnaList">qna</a>
	</p>
</body>
</html>
