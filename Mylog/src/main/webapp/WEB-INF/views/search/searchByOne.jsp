<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>

<link rel="stylesheet" href="/Mylog/resources/search/searchByOne.css">
</head>

<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<aside></aside>
	<div class="main">
		<div class="title">
			<div class="main-wrapper">
				<h1>제목</h1>
				<div class="user-d">
					<div class="userInfo">
						<span>유저이름</span> <span>·</span> <span>4일전</span>
					</div>
					<div class="f&g">
						<button class="follow-btn">팔로우</button>
						<button class="follow-btn">좋아요</button>
					</div>
				</div>
				<div class="img">사진파일</div>

			</div>
		</div>
		<div class="content">
			<h2>소제목</h2>
			<div class="content-area"></div>
		</div>
		<div class="user-e">
			<div class="user-s">
				<div class="left">
					<div class="user-img">유저 이미지</div>
					<div class="user-inf">
						<div class="name">유저이름</div>
						<div class="decription">어쩌구 저쩌구 내용</div>
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
			<h2>n개의 댓글</h2>
			<div class="comment-write">
				<div class="comment-area">
					<textarea name="comment" placeholder="댓글을 작성하세요" rows="8"
						cols="120"></textarea>
					<div>
						<button class="comment-btn">댓글 작성</button>
					</div>
				</div>
				<div class="comment">
					<div class="comment-user">
						<div class="comment-user-img"></div>
						<div>
							<div>이름</div>
							<div>n일 전</div>
						</div>
					</div>
					<div class="comment-content">댓글내용</div>
					<div class="comment-comment">
						<svg width="12" height="12" fill="none" viewBox="0 0 12 12">
							<path fill="currentColor"
								d="M5.5 2.5h1v3h3v1h-3v3h-1v-3h-3v-1h3v-3z"></path>
							<path fill="currentColor" fill-rule="evenodd"
								d="M1 0a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1H1zm10 1H1v10h10V1z"
								clip-rule="evenodd"></path></svg>
						<span class="n-comment">n개의 답글</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<aside></aside>


</body>

</html>