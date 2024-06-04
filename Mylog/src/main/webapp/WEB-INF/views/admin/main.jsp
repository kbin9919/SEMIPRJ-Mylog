<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/admin/layout/util.jsp"%>
</head>

<body>

	<div class="admin-body">
		<%@ include file="/WEB-INF/views/admin/layout/profile.jsp"%>
		<c:if test="${loginAdminVo != null}">
			<div class="admin-content">
				<div class="admin-content-main">
					<div class="admin-search">
						<form action="/Mylog/admin/select/member/list" method="get">
							<div class="search-text">
								<input type="text" name="admin-search" placeholder="검색어를 입력하세요"
									id="search-input">
							</div>
						</form>
					</div>
					<div class="admin-vo-list">
						<table border="2">
							<tr>
								<th>e-mail</th>
								<th>닉네임</th>
								<th>가입일</th>
								<th>탈퇴일</th>
								<th>경고 점수</th>
							</tr>
							<c:forEach items="${memberVoList}" var="vo">
								<tr class="tr"
									onclick="location.href = '/Mylog/admin/select/member/detail?no=${vo.no}'">
									<td>
										<div>${vo.email}</div>
									</td>
									<td>
										<div>${vo.nick}</div>
									</td>
									<td>
										<div>${vo.enrollDate}</div>
									</td>
									<td>
										<div>${vo.delDate}</div>
									</td>
									<td>
										<div>${vo.warningPoint}</div>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
            
		</c:if>
		<%@ include file="/WEB-INF/views/admin/layout/aside.jsp"%>
	</div>

</body>

</html>