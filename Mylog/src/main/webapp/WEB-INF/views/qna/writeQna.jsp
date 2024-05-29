<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="/Mylog/resources/qna/writeQna.css">
</head>
<body>

	<header>
		<div class="top">
			<div>MyLog</div>
			<div>MyHome</div>
			<div class="top-right">
				<div>알림</div>
				<div>검색</div>
				<div id="newBoard">새 글 작성</div>
				<div>set</div>
			</div>
		</div>
	</header>
	<aside></aside>
	<main class="QNA-wpage">
		<h1>Q&A 작성</h1>
		<div class="wqna-title">
			<input type="text" placeholder="제목을 입력하세요" class="title">
		</div>
		<div>
			<textarea id="" class="wqna-content" placeholder="내용을 입력하세요"></textarea>
		</div>
		<div class="btn-main">
			<button class="wbtn">작성하기</button>
		</div>

	</main>


</body>
</html>