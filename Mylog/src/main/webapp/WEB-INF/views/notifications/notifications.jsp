<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>알림</title>
    <style>
        body {
            background-color: rgb(247, 243, 243);
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        header {
            background-color: white;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .top {
            color: black;
            font-weight: 900;
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 13px;
        }
        .content {
            padding: 20px;
        }
        .notification {
            background-color: #fff;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>

<header>
    <div class="top">
        <div class="top-left">
            <div id="myLog" onclick="goToHome()">MyLog</div>
        </div>
        <div class="top-right">
            <button onclick="goToHome()">홈으로</button>
        </div>
    </div>
</header>

<main class="content">
    <h1>알림</h1>
    <div id="notifications">
        <%
            List<Notification> notifications = (List<Notification>) request.getAttribute("notifications");
            if (notifications != null && !notifications.isEmpty()) {
                for (Notification notification : notifications) {
                    out.println("<div class='notification'>" + notification.getMessage() + "</div>");
                }
            } else {
                out.println("<div class='notification'>알림이 없습니다.</div>");
            }
        %>
    </div>
</main>

<script>
    function goToHome() {
        window.location.href = 'mainHome.jsp';
    }
</script>

</body>
</html>
