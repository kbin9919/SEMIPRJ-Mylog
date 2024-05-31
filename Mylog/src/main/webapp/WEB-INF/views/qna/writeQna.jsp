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
		<a href="/Mylog/qna" class="notice-title">
			<div>QNA</div>
		</a>
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
					<td><a href="/Mylog/faq">FAQ</a></td>
				</tr>
				<tr>
					<td><a href="/Mylog/qna" class="tag-focus">QNA</a></td>
				</tr>
			</table>
		</div>
		<div class="notice-main">
			<div class="qna-write-main">
				<form action="/Mylog/writeQna" method="post">
					<div><input type="text" name="qna-title" placeholder="제목을 입력하세요"></div>
					<div><textarea name="qna-content" placeholder="내용을 입력하세요" class="notice-textarea" cols="30" rows="10"></textarea></div>
					<div class="qna-write-input">
						<div>비밀글<input type="checkbox" id="secretYn" name="secretYn"></div>
						<div class="qna-write-submit"><input type="submit" name="qna-write-submit" value="QNA작성"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>