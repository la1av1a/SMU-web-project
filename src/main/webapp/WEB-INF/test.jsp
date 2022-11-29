<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot Application with JSP</title>
</head>
<body>
Hello, Spring Boot App
<h2>이름 : ${name}</h2>
<form action="/v1/user/signIn" method="post">
    <label for="userId">id : </label>
    <input type="text" id="userId" name="userId"><br>
    <label for="userPw">pw : </label>
    <input type="password" id="userPw" name="userPw"><br>
    <label for="userName">userName : </label>
    <input type="text" id=userName name="userName"><br>
    <input type="submit" value="제출">
</form>
</body>
</html>