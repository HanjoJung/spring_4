<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var result = "${result}";
	if (result != '') {
		alert(result);
	}
</script>
</head>
<body>
	<H1>${board.toUpperCase()}Select</H1>
	<p>num : ${boardDTO.num}</p>
	<p>title : ${boardDTO.title}</p>
	<p>writer : ${boardDTO.writer}</p>
	<p>contents : ${boardDTO.contents}</p>
	<p>hit : ${boardDTO.hit}</p>

	<p>
		<button>
			<a href="./${board}Update?num=${boardDTO.num}">${board}Update</a>
		</button>
	</p>
	<form action="./${board}Delete?num=${boardDTO.num}" method="post">
		<button>${board}Delete</button>
	</form>
	<c:if test="${board ne 'notice'}">
		<p>
			<button>
				<a href="./${board}Reply?num=${boardDTO.num}">Reply</a>
			</button>
		</p>
	</c:if>
	<p>
	<p>
		<button>
			<a href="./${board}List">List</a>
		</button>
	</p>
</body>
</html>