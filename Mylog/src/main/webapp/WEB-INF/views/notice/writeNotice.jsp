<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<%@ include file="/WEB-INF/views/layout/util.jsp" %>
	</head>

	<body>
		<%@ include file="/WEB-INF/views/layout/header.jsp" %>
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
						<form action="/Mylog/admin/writer/notice" method="post" enctype="multipart/form-data">
							<div><input type="text" name="qna-title" class="" placeholder="제목을 입력하세요"></div>
								<input type="file" id="file" class="file-input" name="f" multiple>
								<label for="file" class="file-label">Choose a file</label>
								<div style="display: flex; justify-content: end; gap: 13px;">
									<select name="category-No" style="margin-bottom: 10px;">
										<option value="99">로그인</option>
										<option value="98">게시글</option>
										<option value="97">계정</option>
										<option value="96">보안</option>
										<option value="95">기타</option>
										<option value="94">업데이트</option>
									</select>
								</div>
							<div><textarea name="qna-content" placeholder="내용을 입력하세요" class="notice-textarea " cols="30"
									rows="10"></textarea></div>
									<input type="submit" id="notice-write-submit" value="작성하기">
						</form>
					</div>
				</div>
			</div>
	</body>