<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>

  <link rel="stylesheet" href="/Mylog/resources/qna/qna.css">
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
  
  <aside class="left"></aside>
  <div class="first-d">
    <div class="count">전체 n건</div>
    <div class="search-d">
      <form action="">
        <input type="text" class="search" placeholder="제목을 입력하세요.">
        <input type="submit" class="search-s" value="검색">
      </form>
    </div>
  </div>
  <aside class="right"></aside>

  <div class="qna">
    <table border="1" class="qna_title">
      <thead>
        <tr>
          <th class="col1">번호</th>
          <th class="col2">제목</th>
          <th class="col3">작성자</th>
          <th class="col4">카테고리</th>
          <th class="col5">조회수</th>
        </tr>
      </thead>
      <tbody>

      </tbody>
    </table>
  </div>
  <div class="page_area">
    <div class="qna-npage">ds</div>
    <div class="write_qna">
      <button class="write-btn">글쓰기</button>
    </div>
  </div>

</body>

</html>