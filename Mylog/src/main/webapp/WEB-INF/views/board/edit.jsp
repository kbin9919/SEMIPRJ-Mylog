<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<h1>게시글 수정</h1>
	<form action="${pageContext.request.contextPath}/board/edit"
		method="post">
		<input type="hidden" name="no" value="${board.no}">
		<div>
            <label for="categoryNo">카테고리</label>
            <select id="categoryNo" name="categoryNo" required>
                <c:forEach var="category" items="${categoryVoList}">
                    <option value="${category.no}" ${category.no == board.categoryNo ? 'selected' : ''}>
                        ${category.title}
                    </option>
                </c:forEach>
            </select>
        </div>
		<div>
			<label for="title">제목</label> <input type="text" id="title"
				name="title" value="${board.title}" required>
		</div>
		<div>
			<label for="content">내용</label>
			<textarea id="content" name="content" rows="10" cols="30" required>${board.content}</textarea>
		</div>
		<div>
			<button type="submit">수정하기</button>
		</div>
	</form>
</body>
</html>