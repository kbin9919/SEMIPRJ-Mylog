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
					<td><a href="/Mylog/qna" class="">QNA</a></td>
				</tr>
			</table>
		</div>
		<div class="notice-main">
			<div class="qna-write-main">
				<form action="" method="post">
					<div><input type="text" name="qna-title" class="selectQna" placeholder="${noticeVo.title}"></div>
					<div style="display: flex; justify-content: end; gap: 13px;">
						<div class="timeStamp"><input type="text" name="qna-time" class="selectQna" placeholder="카테고리 : ${noticeVo.category}"></div>
						<div class="timeStamp"><input type="text" name="qna-time" class="selectQna" placeholder="작성일 : ${noticeVo.enrollDate}"></div>
					</div>
					<div><textarea name="qna-content" placeholder="${noticeVo.content}" class="notice-textarea selectQna" cols="30" rows="10"></textarea></div>
				</form>
			</div>
		</div>
	</div>
</body>