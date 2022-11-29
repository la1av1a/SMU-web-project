<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="/css/signUpStyle.css">
    <title></title>
</head>
</html>
<body>
<form action="/user/signUp" method="post" class="joinForm" x>

    <h2>회원가입</h2>
    <div class="textForm">
        <input name="userId" type="text" class="id" placeholder="아이디">
    </div>
    <div class="textForm">
        <input name="userPw" type="password" class="pw" placeholder="비밀번호">
    </div>
    <div class="textForm">
        <input name="userName" type="text" class="name" placeholder="이름">
    </div>
    <input type="submit" class="btn" value="J O I N"/>
</form>

</body>