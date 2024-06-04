
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세조회</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/Mylog/resources/search/searchByOne.css">
<script defer src="/Mylog/resources/search/searchByOne.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>



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
						<span>${requestScope.vo.nick}</span> <span>·</span> <span>작성일자
							: ${requestScope.vo.enrollDate}</span>
					</div>
					<c:if
						test="${requestScope.vo.writerNo == sessionScope.loginAdminVo.no}">
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
				<div class="img">
					<c:forEach items="${attVoList}" var="x">
						<img width="100px" height="100px" alt="${x.originName}"
							src="/Mylog/resources/upload/${x.changeName}">
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="content">
			<h2></h2>
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
						<div class="description">${requestScope.vo.introduce}</div>
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
			<h2>${vo.commentCount}개의댓글</h2>
			<c:if test="${ sessionScope.loginAdminVo != null}">
				<div class="comment-write">
					<input type="hidden" name="boardNo" value="${requestScope.vo.no}">
					<div class="comment-area">
						<textarea name="reply-content" placeholder="댓글을 작성하세요" rows="8"
							cols="120"></textarea>
						<div>
							<button onclick="writeReply(${vo.no});">댓글 작성</button>
						</div>
					</div>
				</div>
			</c:if>

			<c:if test="${sessionScope.loginAdminVo == null}">
				<span>로그인 후 댓글 작성 가능합니다.</span>
			</c:if>
		</div>

		<div id="commentContainer"></div>

		<div>
			<button onclick="loadReplyList(${requestScope.vo.no});">댓글
				불러오기</button>
		</div>
	</div>
	<aside></aside>

</body>
</html>
