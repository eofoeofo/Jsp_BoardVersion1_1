<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	<h1>디테일</h1>
	<div><a href="/mod3?iboard=${param.iboard }">수정</a></div>
	<div><a href="/list3">리스트</a></div>
	<div>제목 : ${data.title}</div>
	<div>작성일 : ${data.regdt}</div>
	<div>
		${data.ctnt}
	</div>
	<div>
		<form action="/del3" method="post">
			<input type="hidden" name="iboard" value="${param.iboard}">
			<input type="submit" value="삭제">
		</form>
	</div>
</body>
</html>