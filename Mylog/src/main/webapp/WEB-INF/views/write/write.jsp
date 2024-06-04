<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="/Mylog/resources/write/write.css">
<script defer src="/Mylog/resources/write/write.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

</head>
<body>

	<c:choose>
		<c:when test="${not empty sessionScope.loginAdminVo}">
			<div class="new_board">
				<div class="write_board">
					<form action="/Mylog/board/write" method="post	"
						enctype="multipart/form-data">
						<div class="write_title">
							<textarea name="title" placeholder="제목을 입력하세요" class="title"
								id="inputTitle"></textarea>
						</div>
						<div class="empt"></div>
						<select name="categoryNo">
							<c:forEach var="cvo" items="${categoryVoList}">
								<option value="${cvo.no}">${cvo.title}</option>
							</c:forEach>
						</select>
						<div>
							<svg stroke="currentColor" fill="currentColor" stroke-width="0"
								viewBox="0 0 24 24" height="1em" width="1em"
								xmlns="http://www.w3.org/2000/svg">
                                <path
									d="M21 19V5c0-1.1-.9-2-2-2H5c-1.1 0-2 .9-2 2v14c0 1.1.9 2 2 2h14c1.1 0 2-.9 2-2zM8.5 13.5l2.5 3.01L14.5 12l4.5 6H5l3.5-4.5z"></path>
                            </svg>
							<input type="file" class="img-btn" name="f" multiple>
						</div>
						<div>
							<textarea name="content" id="inputText" class="content-area"
								placeholder="내용을 입력하세요"></textarea>
						</div>
						<div class="set-btn">
							<div>
								<button type="button" class="exit">
									<svg stroke="currentColor" fill="currentColor" stroke-width="0"
										viewBox="0 0 24 24" height="1em" width="1em"
										xmlns="http://www.w3.org/2000/svg">
                                    <path
											d="M20 11H7.83l5.59-5.59L12 4l-8 8 8 8 1.41-1.41L7.83 13H20v-2z"></path>
                                </svg>
									<a href="/Mylog/mypage"><span>나가기</span></a>
								</button>
							</div>
							<div class="s-btn">
								<input type="submit" value="작성">
							</div>
						</div>
					</form>
				</div>
				<div class="check_board">
					<div class="ott" id="outputTitle"></div>
					<div class="otx" id="outputText"></div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="error-message">로그인이 필요합니다.</div>
		</c:otherwise>
	</c:choose>

</body>
</html>