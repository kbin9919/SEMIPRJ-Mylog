<!DOCTYPE html>
<html>
<head>
    <title>회원 추가</title>
</head>
<body>
    <h1>회원 추가</h1>
    <form action="add" method="post">
        <label for="email">이메일:</label>
        <input type="text" id="email" name="email"><br>

        <label for="password">비밀번호:</label>
        <input type="text" id="password" name="password"><br>

        <label for="nick">닉네임:</label>
        <input type="text" id="nick" name="nick"><br>

        <label for="introduction">소개:</label>
        <input type="text" id="introduction" name="introduction"><br>

        <label for="adminYn">관리자 여부 (Y/N):</label>
        <input type="text" id="adminYn" name="adminYn"><br>

        <input type="submit" value="회원 추가">
    </form>
</body>
</html>
