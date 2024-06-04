<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<%@ include file="/WEB-INF/views/layout/util.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	<div class="search">
		<div class="input">
			<form action="/Mylog/board/search" method="post">
				<c:choose>
					<c:when test="${empty sessionScope.searchVo.searchValue}">
						<span id="search-icon"> <svg width="12" height="12"
								viewBox="0 0 17 17">
                                <path fill-rule="evenodd"
									d="M13.66 7.36a6.3 6.3 0 1 1-12.598 0 6.3 6.3 0 0 1 12.598 0zm-1.73 5.772a7.36 7.36 0 1 1 1.201-1.201l3.636 3.635c.31.31.31.815 0 1.126l-.075.075a.796.796 0 0 1-1.126 0l-3.636-3.635z"
									clip-rule="evenodd" fill="currentColor"></path>
                            </svg>
						</span>
						<input type="text" name="search-board" placeholder="검색어를 입력하세요"
							id="search-value">
					</c:when>
					<c:otherwise>
						<input type="text" name="search-board" placeholder=""
							value="${sessionScope.searchVo.searchValue}" id="searchInput">
					</c:otherwise>
				</c:choose>
				<button type="submit">검색</button>
			</form>
			<c:if test="${not empty voList}">
				<div>
					총 <span style="font-weight: 900;">${fn:length(voList)}</span>개의
					포스트를 찾았습니다.
				</div>
			</c:if>
		</div>
		<div class="search-post">
			<c:if test="${not empty voList}">
				<c:forEach items="${voList}" var="vo">
					<div class="search-profile">
						<div>
							<c:forEach items="${attVoList}" var="x">
								<c:if test="${x.boardNo eq vo.no}">
									<img width="100px" height="100px" alt="${x.originName}"
										src="/Mylog/resources/upload/${x.changeName}">
								</c:if>
							</c:forEach>
						</div>
						<div>${sessionScope.MemberVo.nick}</div>
					</div>
					<div class="board">
						<div class="img">
							<img src="" alt="기본이미지">
						</div>
						<div id="board-title">${vo.title}</div>
						<div class="c-summary">내용 요약 : ${vo.content}</div>
						<div id="board-tag">
							<a href="">${vo.category}</a>
						</div>
						<div id="board-etc" class="search-etc">
							<div>${vo.enrollDate}</div>
							<div>${vo.commentCount}개의댓글</div>
							<div>🤍0</div>
						</div>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${empty voList}">
				<span class="not-Find">검색 결과가 존재하지 않습니다. 다시 검색해주세요.</span>
			</c:if>
		</div>
	</div>
</body>
</html>
