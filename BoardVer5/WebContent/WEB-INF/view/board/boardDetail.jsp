<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<a href="list">LIST</a>
</div>
<h1>${data.title }</h1>
<div>
	글번호 : ${data.iboard}
</div>
<div>
	작성자 : ${data.writerNm}
	작성일 : ${data.regdt}
</div>
<div>
	<c:out value="${data.ctnt}"/>
</div>
<c:if test="${not empty sessionScope.loginUser}">
	<div>
		<form id="cmtFrm" onsubmit="return false;">
			<input type="text" id="cmt">
			<input type="button" value="댓글달기" onclick="regCmt();">
		</form>
	</div>
</c:if>
<div id="cmtList" data-login_user_pk="${loginUser.iuser}" data-iboard="${param.iboard }"></div>
<script src="/res/js/boardDetail.js"></script>