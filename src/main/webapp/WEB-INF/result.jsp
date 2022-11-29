<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot Application with JSP</title>
</head>
<body>
Hello, Spring Boot App
<sec:authorize access="isAuthenticated()">
    <p sec:authorize="hasRole('USER')">principal로 꺼낸 ID : <sec:authentication
            property="principal.UserId"/></p>
</sec:authorize>
</body>
</html>