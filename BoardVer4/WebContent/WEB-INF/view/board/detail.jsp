<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
<script defer src="/res/js/boardDetail.js"></script>
<link rel="stylesheet" 
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
	.hidden{ display: none; }
	.fa-heart{ color: red; }
</style>
</head>
<body>
	<c:if test="${data.isFav eq 0}">
		<a href="fav?iboard=${param.iboard}&fav=1"><i class="far fa-heart"></i></a>
	</c:if>
	<c:if test="${data.isFav eq 1}">
		<a href="fav?iboard=${param.iboard}&fav=0"><i class="fas fa-heart"></i></a>
	</c:if>
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
		<form id="updFrm" action="cmt" method="post" class="hidden">
			<input type="hidden" name="iboard" value="${data.iboard}">
			<input type="hidden" name="icmt" value="0">
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글수정">
				<input type="button" value="수정취소" onclick="showInsFrm();">
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
				<tr>
					<td>${item.cmt}</td>
					<td>${item.unm}</td>
					<td>${item.regdate}</td>
					<td>
						<c:if test="${loginUser.iuser == item.iuser}">
							<input type="button" value="수정"
							onclick="updCmt(${item.icmt},'${item.cmt}')">
							<input type="button" value="삭제"
							onclick="delCmt(${data.iboard},${item.icmt})">
						</c:if>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>