<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="notice-list">
	<c:forEach items="${noticeVoList}" var="vo">
		<a href="/Mylog/select/notice?no=${vo.no}" class="notice-content">
			<div class="highlightable">${vo.title}</div> <img src="/Mylog/resources/upload/${vo.png}" alt="png.">
			<div class="highlightable">${vo.content}</div>
		</a>
	</c:forEach>
</div>
<div id="notice-count">${noticeCount}</div>
