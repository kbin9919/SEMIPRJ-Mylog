<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/layout/util.jsp"%>
<script defer src="/Mylog/resources/notice/search.js"></script>
</head>

<body>
	<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	<div class="notice-body">
		<a href="/Mylog/notice" class="notice-title">
			<div>공지사항</div>
		</a>
		<div class="tag notice-tag">
			<table>
				<tr>
					<td>
						<div id="tagList">태그 목록</div>
					</td>
				</tr>
				<tr>
					<td><a href="/Mylog/notice" class="tag-focus">NOTICE</a></td>
				</tr>
				<tr>
					<td><a href="/Mylog/faq">FAQ</a></td>
				</tr>
				<tr>
					<td><a href="/Mylog/qna">QNA</a></td>
				</tr>
			</table>
		</div>
		<div class="notice-main">
			<%@ include file="/WEB-INF/views/layout/community.jsp"%>

			<div class="range">
				<div class="notice-search-array">
					<div class="array-title">title</div>
					<div class="array-content">content</div>
				</div>
				<div class="notice-content-sell">
					<c:if test="${!empty noticeVoList}">
					<c:forEach items="${noticeVoList}" var="vo">
						<a href="/Mylog/select/notice?no=${vo.no}" class="notice-content">
							<div class="highlightable">${vo.title}</div> <img src="" alt="png.">
							<div class="highlightable">${vo.content}</div>
						</a>
					</c:forEach>
					</c:if>
					<c:if test="${empty noticeVoList}">
							<span class="not-Find">검색 결과가 존재하지 않습니다. 다시 검색해주세요.</span>
					</c:if>
				</div>
			</div>
		</div>
</body>

</html>