<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	<div><a href="list">리스트</a></div>
	<c:if test="${loginUser.iuser == data.iuser}">
	<div>
		<a href="del?iboard=${param.iboard}">삭제</a>
		<a href="mod?iboard=${param.iboard}">수정</a>
	</div>
	</c:if>
	<div>디테일 페이지</div>
	<div>iuser pk값 : ${loginUser.iuser}</div>
	<div>유저 pk값 : ${data.iuser} 작성자 : ${data.unm}</div>
	<div>
		제목 : ${data.title}
	</div>
	<div>
		내용 : ${data.ctnt}
	</div>
	<div>
		작성일자 : ${data.regdt}
	</div>
	<h1>댓글</h1>
		<form id="insFrm" action="cmt" method="post">
			<input type="hidden" name="iboard" value="${data.iboard}">
			<input type="hidden" name="icmt" value="0">
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글작성">
			</div>
		</form>
		<div>
			<table>
				<tr>
					<th>내용</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>비고</th>
				</tr>
				<c:forEach items="${list}" var="item">
				<div>${item.cmt}</div>
				<tr>
					<td>${item.cmt}</td>
					<td>${item.unm}</td>
					<td>${item.regdate}</td>
					<td>${item.unm}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>