<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="admin-profile">
	<img src="" alt="이미지 파일">
	<c:if test="${loginAdminVo == null}">
		<div>not found</div>
	</c:if>
	<c:if test="${loginAdminVo != null}">
		<div> ${loginAdminVo.nick} </div>
	</c:if>
</div>
