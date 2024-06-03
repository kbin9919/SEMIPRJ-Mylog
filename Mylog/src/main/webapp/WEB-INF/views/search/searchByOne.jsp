<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세조회</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/Mylog/resources/search/searchByOne.css">
<script src="/Mylog/resources/search/searchByOne.js"></script>

</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<aside></aside>
	<div class="main">
		<div class="title">
			<div class="main-wrapper">
				<div>
					<h1>제목 : ${requestScope.vo.title}</h1>
				</div>
				<div class="user-d">
					<div class="userInfo">
						<span>작성자 : ${requestScope.vo.nick}</span> <span>·</span> <span>작성일자
							: ${requestScope.vo.enrollDate}</span>
					</div>
					<c:if
						test="${requestScope.vo.writerNo == sessionScope.loginMember.no}">
						<button
							onclick="location.href='/Mylog/board/edit?no=${requestScope.vo.no}'">수정</button>
						<button
							onclick="location.href='/Mylog/board/delete?no=${requestScope.vo.no}'">삭제</button>
					</c:if>
					<div class="f&g">
							<button class="follow-btn">팔로우</button>
							<button class="follow-btn">좋아요</button>
				</div>
			</div>
			<div class="img">사진파일</div>
		</div>
	</div>
	<div class="content">
		<h2>소제목 적는 기능 없음</h2>
		<div class="content-area">${requestScope.vo.content}</div>
	</div>
	<div class="user-e">
		<div class="user-s">
			<div class="left">
				<div class="user-img">
					<a href="/Mylog/mypage">유저 이미지</a>
				</div>
				<div class="user-inf">
					<div class="name">${requestScope.vo.nick}</div>
					<div class="description">${requestScope.vo.introduction}</div>
				</div>
			</div>
			<div class="right">
				<button class="follow-btn">팔로우</button>
			</div>
		</div>
		<div>
			<hr>
		</div>
	</div>


	<div class="comment-main">
		<h2>${requestScope.vo.comments.size()}개의댓글</h2>
		<div class="comment-write">
			<form action="/comment/write" method="post">
				<input type="hidden" name="boardNo" value="${requestScope.vo.no}">
				<div class="comment-area">
					<textarea name="content" placeholder="댓글을 작성하세요" rows="8"
						cols="120"></textarea>
					<div>
						<button type="submit" class="comment-btn">댓글 작성</button>
					</div>
				</div>
			</form>
		</div>

		<div class="comment">
			<c:forEach var="comment" items="${requestScope.vo.comments}">
				<div class="comment-user">
					<div class="comment-user-img"></div>
					<div>
						<div>${comment.writerNick}</div>
						<div>${comment.writeDate}</div>
						<c:if test="${comment.writerNo == sessionScope.loginMember.no}">
							<button
								onclick="location.href='/app/comment/edit?no=${comment.no}'">수정</button>
							<button
								onclick="location.href='/app/comment/delete?no=${comment.no}'">삭제</button>
						</c:if>
					</div>
				</div>
				<div class="comment-content">${comment.content}</div>
				<div class="comment-comment">
					<svg width="12" height="12" fill="none" viewBox="0 0 12 12">
                            <path fill="currentColor"
							d="M5.5 2.5h1v3h3v1h-3v3h-1v-3h-3v-1h3v-3z"></path>
                            <path fill="currentColor"
							fill-rule="evenodd"
							d="M1 0a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1H1zm10 1H1v10h10V1z"
							clip-rule="evenodd"></path>
                        </svg>
					<span class="n-comment">${comment.replies.size()}개의 답글</span>
				</div>
			</c:forEach>
		</div>
	</div>
	</div>
	<aside></aside>

</body>
</html>
