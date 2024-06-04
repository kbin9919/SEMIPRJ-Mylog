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
		<a href="/Mylog/faq" class="notice-title">
			<div>FAQ</div>
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
					<td><a href="/Mylog/faq" class="tag-focus">FAQ</a></td>
				</tr>
				<tr>
					<td><a href="/Mylog/qna" class="">QNA</a></td>
				</tr>
			</table>
		</div>
		<div class="notice-main">
			<div class="qna-write-main">
				<form action="/Mylog/admin/writer/faq" method="post">
					<div><input type="text" name="qna-title" class="" placeholder="게시글 제목"></div>
					<div><textarea name="qna-content" placeholder="게시글 내용" class="notice-textarea " cols="30" rows="10"></textarea></div>
					<input type="submit" style="border: 2px solid; black; border-radius: 20px; padding:5px; width: 65px; background-color: rgb(94, 210, 45); cursor:pointer; position: relative; left: 750px">
				</form>
			</div>
		</div>
	</div>
</body>