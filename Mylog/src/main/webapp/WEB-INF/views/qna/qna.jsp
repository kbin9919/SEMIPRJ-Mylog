<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/layout/util.jsp"%>
<script defer src="/Mylog/resources/qna/qna.js"></script>
</head>

<body>
	<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	<div class="notice-body">
		<div class="notice-title">
			<div>QNA</div>
		</div>
		<div class="tag notice-tag">
			<table>
				<tr>
					<td>
						<div id="tagList">태그 목록</div>
					</td>
				</tr>
				<tr>
					<td><a href="/Mylog/notice" class="">NOTICE</a></td>
				</tr>
				<tr>
					<td><a href="/Mylog/faq">FAQ</a></td>
				</tr>
				<tr>
					<td><a href="/Mylog/qna" class="tag-focus">QNA</a></td>
				</tr>
			</table>
		</div>
		<div class="notice-main">
			<div class="notice-search">
				<form action="" method="post">
					<div>
						<span> <svg id="notice-svg" width="19" height="19"
								viewBox="0 0 17 17">
                                        <path fill-rule="evenodd"
									d="M13.66 7.36a6.3 6.3 0 1 1-12.598 0 6.3 6.3 0 0 1 12.598 0zm-1.73 5.772a7.36 7.36 0 1 1 1.201-1.201l3.636 3.635c.31.31.31.815 0 1.126l-.075.075a.796.796 0 0 1-1.126 0l-3.636-3.635z"
									clip-rule="evenodd" fill="currentColor"></path>
                                    </svg>
						</span>
					</div>
					<input type="text" name="faq-search" placeholder="검색어를 입력하세요">
				</form>
			</div>
			<div class="range">
				<div class="notice-search-array">
					<div>ALL</div>
					<div>MY</div>
					<span class="qna-write">
						<a href="/Mylog/writeQna">QNA작성</a>
					</span>	
				</div>
				
			</div>
			<div class="notice-content-sell">
				<c:set var="checkY" value="Y" />
				<c:set var="checkN" value="N" />
				<c:forEach items="${qnaVoList}" var="vo">
					<c:if test="${vo.secretYn eq checkY}">
						<a  class="notice-content">
							<div style="color: gray">🔒비밀글입니다</div>
							<div></div>
							<div></div>
						</a>
					</c:if>
					<c:if test="${vo.secretYn eq checkN}">
						<a href="/Mylog/select/qna?no=${vo.no}" class="notice-content">
							<div>${vo.title}</div> <img src="" alt="png.">
							<div>${vo.content}</div>
						</a>
					</c:if>
				</c:forEach>
			</div>

		</div>

	</div>
</body>

</html>