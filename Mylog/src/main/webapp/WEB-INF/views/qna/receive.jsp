<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="qna-list">
	<c:set var="checkY" value="Y" />
	<c:set var="checkN" value="N" />
	<c:forEach items="${qnaVoList}" var="vo">
		<c:if test="${vo.secretYn eq checkY}">
			<a class="notice-content">
				<div style="color: gray">🔒비밀글입니다</div>
				<div></div>
				<div></div>
			</a>
		</c:if>
		<c:if test="${vo.secretYn eq checkN}">
			<a href="/Mylog/select/qna?no=${vo.no}" class="notice-content">
				<div>${vo.title}</div> <img src="" alt="png.">
				<div>${vo.content}</div>
			</a>
		</c:if>
	</c:forEach>
</div>
<div id="qna-count">${qnaCount}</div>