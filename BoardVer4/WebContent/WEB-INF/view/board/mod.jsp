<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<h1>수정</h1>
	<div>
		<form action="mod" method="post">
		<input type="hidden" name="iboard" value="${param.iboard}">
			<div>
				제목 : <input type="text" name="title" value="${data.title}">
			</div>
			<div>
				내용 : <textarea name="ctnt" placeholder="내용">${data.ctnt}</textarea>
			</div>
			<div>
				<input type="submit" value="수정">
				<input type="reset" value="초기화">
			</div>
		</form>
	</div>
</body>
</html>