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
				<form action="" method="post">
					<c:if test="${loginAdminVo != null}">
					<a href="/Mylog/admin/delete/faq?no=${faqVo.no}" style="position: relative; left: 800px; bottom: 12px" >❌</a>
					</c:if>
					<div><input type="text" name="qna-title" class="selectQna" placeholder="${faqVo.title}"></div>
					<div class="timeStamp"><input type="text" name="qna-time" class="selectQna" placeholder="작성일 : ${faqVo.enrollDate}"></div>
					<div><textarea name="qna-content" placeholder="${faqVo.content}" class="notice-textarea selectQna" cols="30" rows="10"></textarea></div>
				</form>
			</div>
		</div>
	</div>
</body>