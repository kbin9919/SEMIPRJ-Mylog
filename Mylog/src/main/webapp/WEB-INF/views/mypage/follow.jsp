<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta charset="UTF-8">
    	<title>팔로우/팔로잉</title>
        <%@ include file="/WEB-INF/views/layout/util.jsp" %>
    </head>
    <body>
        <%@ include file="/WEB-INF/views/layout/header.jsp" %>
    <div class="with">
            <div class="with-togle">
                    <a class="with-focus">팔로워</a>
                <a>팔로잉</a>
            </div>
            <div class="with-search">
                <form action="" method="post">
                    <span id="search-icon">
                    	<svg width="12" height="12" viewBox="0 0 17 17">
                    		<path fill-rule="evenodd" d="M13.66 7.36a6.3 6.3 0 1 1-12.598 0 6.3 6.3 0 0 1 12.598 0zm-1.73 5.772a7.36 7.36 0 1 1 1.201-1.201l3.636 3.635c.31.31.31.815 0 1.126l-.075.075a.796.796 0 0 1-1.126 0l-3.636-3.635z" clip-rule="evenodd" fill="currentColor"></path>
                    	</svg>
                    </span><input type="text" name="midle-search" placeholder="검색어를 입력하세요">
                </form>
            </div>
            <div class="with-list">
                <div>모든 팔로워</div>
                <div class="with-list-name">
                    <div id="with-img"><a href=""><img src="" alt="사진"></a></div>
                    <div><div><a href="">이름</a></div><a href=""><div id="with-email">이메일</div></a></div>
                    <div id="with-following">팔로잉</div>
                    <div>소개문구</div>
                </div>
            </div>
    </div>
</body>
</html>