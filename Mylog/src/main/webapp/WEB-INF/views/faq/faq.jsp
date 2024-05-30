<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/layout/util.jsp"%>
</head>

<body>
	<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	<div class="notice-body">
		<div class="notice-title">
			<div>FAQ</div>
		</div>
		<div class="tag notice-tag">
			<table>
				<tr>
					<td>
						<div id="tagList">태그 목록</div>
					</td>
				</tr>
				<tr>
					<td><a href="/Mylog/notice" class="">NOTICE</a></td>
				</tr>
				<tr>
					<td><a href="/Mylog/faq" class="tag-focus">FAQ</a></td>
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
					<div>title</div>
					<div>content</div>
				</div>
				<div class="page">
					<div> < </div>
					<div style="font-size: 14px; width: 57px;"> page </div>
					<div> > </div>
				</div>
			</div>
			<a href="/Mylog/select/faq" class="notice-content">
				<div>title</div>
				<img src="" alt="png.">
				<div>content</div>
			</a>
			<a href="/Mylog/select/faq" class="notice-content">
				<div>title</div>
				<img src="" alt="png.">
				<div>content</div>
			</a>
			<a href="/Mylog/select/faq" class="notice-content">
				<div>title</div>
				<img src="" alt="png.">
				<div>content</div>
			</a>
			<a href="/Mylog/select/faq" class="notice-content">
				<div>title</div>
				<img src="" alt="png.">
				<div>content</div>
			</a>
		</div>
	</div>
</body>

</html>