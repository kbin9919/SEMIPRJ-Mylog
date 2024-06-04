<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <%@ include file="/WEB-INF/views/admin/layout/util.jsp" %>
    </head>

    <body>
        <div class="admin-body">
            <%@ include file="/WEB-INF/views/admin/layout/profile.jsp" %>
                <div class="admin-content">
                    <div class="admin-content-main">
                        <div style="font-size: 25px; font-weight: 900;">관리자 로그인</div>
                        <div class="login-board">
                            <div>
                                <form action="/Mylog/admin/login" method="post">
                                    <div>
                                    <input type="text" name="email" placeholder="아이디를 입력하세요">
                                    </div>
                                    <div>
                                    <input type="password" name="password" placeholder="비밀번호를 입력하세요">
                                    </div>
                                    <input type="submit" id="login-submit">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <%@ include file="/WEB-INF/views/admin/layout/aside.jsp" %>
        </div>
    </body>

    </html>