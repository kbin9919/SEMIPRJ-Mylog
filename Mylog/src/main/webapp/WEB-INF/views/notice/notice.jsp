<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/layout/util.jsp"%>
<script defer src="/Mylog/resources/notice/notice.js"></script>
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
				<div class="notice-content-sell">
					<c:forEach items="${noticeVoList}" var="vo">
						<a href="/Mylog/select/notice?no=${vo.no}" class="notice-content">
							<div>${vo.title}</div> <img src="" alt="png.">
							<div>${vo.content}</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
</body>

</html>