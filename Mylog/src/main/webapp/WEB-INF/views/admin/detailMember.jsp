<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <%@ include file="/WEB-INF/views/admin/layout/util.jsp" %>
    </head>

    <body>
        <div class="admin-body">
            <%@ include file="/WEB-INF/views/admin/layout/profile.jsp" %>
                <div class="admin-content">
                    <div class="admin-content-main">
                        <div class="memberVo">
                            <div class="member-img"><img src="" alt="사진파일"></div>
                            <div style="grid-column: span 2;">e-mail : ${memberVo.email}</div>
                            <div style="grid-column: span 2;">닉네임 : ${memberVo.nick}</div>
                            <c:if test="${memberVo.introduction == null}">
                                <div style="grid-column: span 3; color: rgb(81, 81, 81);">소개글이 작성되지 않았습니다.</div>
                            </c:if>
                            <c:if test="${memberVo.introduction != null}">
                                <div style="grid-column: span 3;">${memberVo.introduction}</div>
                            </c:if>
                            <div>가입일 : ${memberVo.enrollDate}</div>
                            <div>탈퇴 유무 : ${memberVo.delDate}</div>
                            <div>경고 점수 : ${memberVo.warningPoint}</div>
                            <div style="grid-column: span 3;" class="warning-botton">
                                <a href="" >경고하기</a>
                                <a href="" >제제하기</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%@ include file="/WEB-INF/views/admin/layout/aside.jsp" %>
        </div>
    </body>

    </html>