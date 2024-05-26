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
        
    <div class="setting">
        <div class="setting-profile">
            <div class="setting-img">
                <div>사진 파일</div>
                <a href="">이미지 업로드</a>
                <a href="">이미지 제거</a>
            </div>
            <div class="setting-info">
                <div>이름</div>
                <div>한줄 소개</div>
                <div class="setting-Change"><div>수정</div></div>
            </div>
        </div>
        <div class="setting-list">
            <div>
                <div class="setting-list-title">소셜 정보</div>
                <div class="setting-Change">정보 추가</div>
                <div>포스트 및 블로그에서 보여지는 프로필에 공개되는 소셜 정보입니다.</div>
            </div>
            <div>
                <div class="setting-list-title">테마</div>
                <div class="setting-list-tema">
                    <div><img src="" alt="이미지"></div>
                    <div><img src="" alt="이미지"></div>
                    <div><img src="" alt="이미지"></div>
                </div>
            </div>
            <div>
                <a href="" class="setting-list-title setting-list-quit">회원 탈퇴</a>
                <div>탈퇴 시 작성하신 포스트 및 댓글이 모두 삭제되며 복구되지 않습니다.</div>
            </div>
        </div>
    </div>
</body>
</html>