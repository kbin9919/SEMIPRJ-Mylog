<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta charset="UTF-8">
    	<title>마이페이지</title>
        <%@ include file="/WEB-INF/views/layout/util.jsp" %>
    </head>
    <body>
        <%@ include file="/WEB-INF/views/layout/header.jsp" %>
    <div class="search">
        <div class="input">
            <form action="" method="post">
                <span id="search-icon">
                	<svg width="12" height="12" viewBox="0 0 17 17">
                    	<path fill-rule="evenodd" d="M13.66 7.36a6.3 6.3 0 1 1-12.598 0 6.3 6.3 0 0 1 12.598 0zm-1.73 5.772a7.36 7.36 0 1 1 1.201-1.201l3.636 3.635c.31.31.31.815 0 1.126l-.075.075a.796.796 0 0 1-1.126 0l-3.636-3.635z" clip-rule="evenodd" fill="currentColor"></path>
                    </svg>
                </span><input type="text" name="search" placeholder="검색어를 입력하세요">
            </form>
            <div>총 <span style="font-weight: 900;">n</span>개의 포스트를 찾았습니다.</div>
        </div>
        <div class="search-post">
            <div class="search-profile">
                <div>사진 파일</div>
                <div>이름</div>
            </div>
            <div class="board">
                <div class="img"><img src="" alt="기본이미지"></div>
                <div id="board-title">제목 : 프로그래머스</div>
                <div>내용 요약 : 게시글의 내용을 n글자 까지 표시</div>
                <div id="board-tag">
                    <a href="">프로그래머스</a>
                    <a href="">12345문제</a>
                    <a href="">123</a>
                </div>
                <div id="board-etc" class="search-etc">
                    <div>작성 시간</div>
                    <div>0개의 댓글</div>
                    <div>🤍0</div>
                </div>
            </div>
        </div>
    </div>
    
</body>
</html>