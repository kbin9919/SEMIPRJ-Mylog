<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="admin-list">
	<c:if test="${loginAdminVo == null}">
		<a href="/Mylog/admin/login">로그인</a>
	</c:if>
	<c:if test="${loginAdminVo != null}">
		<a href="/Mylog/admin/logout">로그아웃</a>
	</c:if>
	<c:if test="${loginAdminVo != null}">
		<a href="/Mylog/admin/main">계정조회</a>
	</c:if>
	<c:if test="${loginAdminVo == null}">
		<a href="">계정조회</a>
	</c:if>
	<c:if test="${loginAdminVo != null}">
		<a href="/Mylog/notice">공지사항</a>
	</c:if>
	<c:if test="${loginAdminVo == null}">
		<a href="">공지사항</a>
	</c:if>
	<c:if test="${loginAdminVo != null}">
		<a href="/Mylog/faq">FAQ</a>
	</c:if>
	<c:if test="${loginAdminVo == null}">
		<a href="">FAQ</a>
	</c:if>
	<c:if test="${loginAdminVo != null}">
		<a href="/Mylog/qna">QNA</a>
	</c:if>
	<c:if test="${loginAdminVo == null}">
		<a href="">QNA</a>
	</c:if>
</div>