<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mylog/resources/post/post.css">
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

	<div class="main-mail">
		<ul class="mail-list">
			<li><svg class="fir" aria-hidden="true"
					xmlns="http://www.w3.org/2000/svg" width="24" height="24"
					fill="none" viewBox="0 0 24 24">
          <path stroke="currentColor" stroke-linecap="round"
						stroke-linejoin="round" stroke-width="2"
						d="M4 13h3.439a.991.991 0 0 1 .908.6 3.978 3.978 0 0 0 7.306 0 .99.99 0 0 1 .908-.6H20M4 13v6a1 1 0 0 0 1 1h14a1 1 0 0 0 1-1v-6M4 13l2-9h12l2 9" />
        </svg> 전체메일함</li>
			<li><svg class="sec" aria-hidden="true"
					xmlns="http://www.w3.org/2000/svg" width="24" height="24"
					fill="none" viewBox="0 0 24 24">
          <path stroke="currentColor" stroke-linecap="round"
						stroke-linejoin="round" stroke-width="2"
						d="M11 16v-5.5A3.5 3.5 0 0 0 7.5 7m3.5 9H4v-5.5A3.5 3.5 0 0 1 7.5 7m3.5 9v4M7.5 7H14m0 0V4h2.5M14 7v3m-3.5 6H20v-6a3 3 0 0 0-3-3m-2 9v4m-8-6.5h1" />
        </svg> 보낸메일함</li>
			<li><svg class="third" aria-hidden="true"
					xmlns="http://www.w3.org/2000/svg" width="24" height="24"
					fill="none" viewBox="0 0 24 24">
          <path stroke="currentColor" stroke-linecap="round"
						stroke-linejoin="round" stroke-width="2"
						d="M4 13h3.439a.991.991 0 0 1 .908.6 3.978 3.978 0 0 0 7.306 0 .99.99 0 0 1 .908-.6H20M4 13v6a1 1 0 0 0 1 1h14a1 1 0 0 0 1-1v-6M4 13l2-9h12l2 9M9 7h6m-7 3h8" />
        </svg> 받은메일함</li>
		</ul>
	</div>
	<div class="main">
		<div class="main-d">
			<div class="dd">
				<div class="align-center">
					<svg class="caller" aria-hidden="true"
						xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="none" viewBox="0 0 24 24">
            <path stroke="currentColor" stroke-width="2"
							d="M7 17v1a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1v-1a3 3 0 0 0-3-3h-4a3 3 0 0 0-3 3Zm8-9a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z" />
          </svg>
					<span>발신자</span>
				</div>
				<div class="align-center">
					<svg class="title" aria-hidden="true"
						xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="none" viewBox="0 0 24 24">
            <path stroke="currentColor" stroke-linecap="round"
							stroke-width="2"
							d="m3.5 5.5 7.893 6.036a1 1 0 0 0 1.214 0L20.5 5.5M4 19h16a1 1 0 0 0 1-1V6a1 1 0 0 0-1-1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1Z" />
          </svg>
					<span>제목</span>
				</div>
				<div class="align-center">
					<svg class="received-time" aria-hidden="true"
						xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="none" viewBox="0 0 24 24">
            <path stroke="currentColor" stroke-linecap="round"
							stroke-linejoin="round" stroke-width="2"
							d="M12 8v4l3 3m6-3a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
          </svg>
					<span>시간</span>
				</div>
			</div>
		</div>
	</div>

</body>
</html>