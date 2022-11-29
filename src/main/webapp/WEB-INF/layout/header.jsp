<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>웹 프로젝트</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="row">
    <div class="col-md-6">
        <a href="/posts/save" role="button" class="btn btn-primary">글 등록</a>
        <sec:authorize access="isAuthenticated()">
            Logged in as: <span id="user">{{userName}}</span>
            <a href="/logout" class="btn btn-info active" role="button">Logout</a>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            <a href="/login" class="btn btn-success active" role="button">User
                Login</a>
        </sec:authorize>
    </div>
</div>