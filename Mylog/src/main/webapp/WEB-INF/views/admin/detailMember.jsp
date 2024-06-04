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
                            <div class="warning-botton">
                                <div class="warning-member">경고하기</div>
                                <div class="del-member">제제하기</div>
                            </div>
                        </div>
                    </div>
                </div>
                <%@ include file="/WEB-INF/views/admin/layout/aside.jsp" %>
        </div>
        <div class="warning-text hidden">
            <div>e-mail  </div>
            <div>${memberVo.email}</div>
            <div>경고 사유  </div>
            <select name="warning-list" id="select">    
                <option value="1">욕설</option>
                <option value="2">선정적인 콘텐츠</option>
                <option value="3">도배</option>
                <option value="4">광고</option>
            </select>
            <div class="check-warning">
                <div id="warning-ok">확인</div>
                <div id="warning-back">취소</div>
            </div>
            <div class="hidden member-no">${memberVo.no}</div>
        </div>
        <c:if test="${memberVo.warningPoint >= 100}">
        <div class="del-text hidden">
            <div>정말로 계정을 제제하시겠습니까?</div>
            <div class="check-warning">
                <div id="del-ok">확인</div>
                <div id="del-back">취소</div>
            </div>
        </div>
        </c:if>

        <c:if test="${memberVo.warningPoint < 100}">
        <div class="del-text hidden">
            <div>경고 점수가 100점 미만인 계정입니다.</div>
            <div class="check-warning">
                <div id="del-back">취소</div>
            </div>
        </div>
        </c:if>
        
    </body>

    </html>