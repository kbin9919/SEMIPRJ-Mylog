<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.yourpackage.MemberVO" %>
<%@ page import="com.yourpackage.dao.BoardDAO" %>
<%@ page import="com.yourpackage.vo.BoardVO" %>
<%@ page import="java.util.List" %>
<%
    HttpSession session = request.getSession();
    MemberVO loggedInMember = (MemberVO) session.getAttribute("loggedInMember");

    // 게시글 가져오기
    BoardDAO boardDAO = new BoardDAO();
    List<BoardVO> posts = boardDAO.getAllPosts();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>블로그 메인화면</title>
    <style>
        /* 기본 스타일 */
        body {
            background-color: rgb(247, 243, 243);
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        /* 헤더 스타일 */
        header {
            background-color: white;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .top {
            color: black;
            font-weight: 900;
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 13px;
        }
        .top-left {
            display: flex;
            gap: 15px;
            align-items: center;
        }
        #myLog {
            font-size: 24px; /* MyLog 버튼 크기 조절 */
            cursor: pointer;
        }
        .top-right {
            display: flex;
            gap: 15px;
            align-items: center;
        }
        #newBoard {
            display: flex;
            justify-content: center;
            align-items: center;
            border: 1px solid black;
            border-radius: 25px;
            width: 80px;
            height: 30px;
            background-color: rgb(244, 246, 247);
            cursor: pointer;
        }
        /* 필터 버튼 스타일 */
        .filter-buttons {
            display: flex;
            justify-content: flex-start;
            margin: 10px 0;
            gap: 5px;
            grid-column: span 3;
        }
        .filter-buttons button {
            padding: 8px 15px; 
            background-color: transparent;
            color: black;
            border: 1px solid #ccc;
            cursor: pointer;
            font-size: 12px;
            transition: background-color 0.3s;
        }
        .filter-buttons button:hover {
            background-color: #e0e0e0;
        }
        /* 블로그 포스트 그리드 스타일 */
        .blog-container {
            display: grid;
            gap: 20px;
            padding: 20px;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
        }
        .blog-post {
            background-color: #f4f4f4;
            padding: 20px;
            border: 1px solid #ddd;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s;
            width: 80%;
            margin: 10px auto;
        }
        .blog-post:hover {
            transform: scale(1.05);
        }
        .blog-post img {
            width: 100%;
            height: auto;
        }
        .blog-post h3 {
            font-size: 1.2em;
            margin: 10px 0;
        }
        .blog-post p {
            font-size: 1em;
            color: #666;
        }
    </style>
</head>
<body>

<header>
    <div class="top">
        <div class="top-left">
            <div id="myLog" onclick="goToHome()">MyLog</div> <!-- MyLog 버튼 -->
        </div>
        <div class="top-right">
            <div onclick="goToNotifications()">알림</div> <!-- 알림 버튼 -->
            <div onclick="goToSearch()">검색</div> <!-- 검색 버튼 -->
            <div id="newBoard" onclick="goToWrite()">새 글 작성</div> <!-- 새 글 작성 버튼 -->
            <% if (loggedInMember != null) { %>
                <button onclick="goToMyPage()">마이페이지</button> <!-- 마이페이지 버튼 -->
                <button onclick="logout()">로그아웃</button> <!-- 로그아웃 버튼 -->
            <% } else { %>
                <button onclick="goToLoginPage()">로그인</button> <!-- 로그인 버튼 -->
            <% } %>
        </div>
    </div>
</header>

<!-- 필터 버튼 -->
<div class="filter-buttons">
    <button onclick="filterPosts('popular')">트렌딩</button>
    <button onclick="filterPosts('latest')">최신</button>
    <button onclick="filterPosts('following')">피드</button>
</div>

<main>
    <div class="blog-container" id="blogContainer">
        <% for (BoardVO post : posts) { %>
            <div class="blog-post" data-type="<%= post.getCategoryNo() %>">
                <img src="https://via.placeholder.com/300x200" alt="포스트 이미지">
                <h3><%= post.getTitle() %></h3>
                <p><%= post.getContent() %></p>
            </div>
        <% } %>
    </div>
    <div id="loading" style="text-align: center; display: none;">
        <img src="loading.gif" alt="loading"> <!-- 로딩 중 이미지 -->
    </div>
</main>

<script>
    let isLoading = false; // 로딩 중인지 여부

    // 페이지 로드 시 실행
    window.onload = function () {
        window.addEventListener('scroll', handleScroll); // 스크롤 이벤트 리스너 등록
    };

    // 스크롤 핸들러
    function handleScroll() {
        if (isLoading) return;

        const { scrollTop, scrollHeight, clientHeight } = document.documentElement;
        if (scrollTop + clientHeight >= scrollHeight - 5) {
            isLoading = true;
            showLoading(); // 로딩 이미지를 표시합니다.
            setTimeout(() => {
                hideLoading(); // 로딩 이미지를 숨깁니다.
                addMorePosts(); // 더 많은 포스트를 추가합니다.
                isLoading = false;
            }, 2000); // 2초 후에 실행합니다.
        }
    }

    // 로딩 이미지 표시
    function showLoading() {
        const loading = document.getElementById('loading');
        loading.style.display = 'block'; // 로딩 요소를 표시합니다.
    }

    // 로딩 이미지 숨김
    function hideLoading() {
        const loading = document.getElementById('loading');
        loading.style.display = 'none'; // 로딩 요소를 숨깁니다.
    }

    // 더 많은 포스트 추가
    function addMorePosts() {
        // 서버에서 더 많은 포스트를 가져와서 추가하는 로직을 구현
    }

    // 페이지 이동 함수
    function goToHome() {
        window.location.href = 'mainHome.jsp';
    }
    function goToNotifications() {
        window.location.href = 'notifications.jsp';
    }
    function goToSearch() {
        window.location.href = 'search.jsp';
    }
    function goToWrite() {
        window.location.href = 'write.jsp';
    }
    function goToLoginPage() {
        window.location.href = 'login.jsp';
    }
    function goToMyPage() {
        window.location.href = 'editMember.jsp';
    }
    function logout() {
        window.location.href = 'logout.jsp';
    }

    // 필터링된 포스트 렌더링
    function filterPosts(filter) {
        const blogContainer = document.getElementById('blogContainer');
        const posts = blogContainer.getElementsByClassName('blog-post');
        for (let post of posts) {
            if (filter === 'all' || post.getAttribute('data-type') === filter) {
                post.style.display = 'block';
            } else {
                post.style.display = 'none';
            }
        }
    }
</script>

</body>
</html>
