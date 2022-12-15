<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="./layout/header.jsp" %>

<div class="col-md-12">
    <div class="row">
        <div class="col-md-6">
            <a href="/posts/save" role="button" class="btn btn-primary">글 등록</a>
            <sec:authorize access="isAuthenticated()">
                Logged in as: <span id="user"><sec:authentication
                    property="principal.username"/></span>
                <a href="/logout" class="btn btn-info active" role="button">Logout</a>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <a href="/login" class="btn btn-success active" role="button">User
                    Login</a>
                <a href="/user/signUp" class="btn btn-secondary active" role="button">SignUp</a>
            </sec:authorize>
        </div>
    </div>
    <br>
    <!-- 목록 출력 영역 -->
    <table class="table table-horizontal table-bordered">
        <thead class="thead-strong">
        <tr>
            <th>게시글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>최종수정일</th>
        </tr>
        </thead>
        <tbody id="tbody">
        <c:forEach var="post" items="${postList}">
            <tr>
                <td>${post.id}</td>
                <td><a href="/posts/${post.id}">${post.title}</a></td>
                <td>${post.author}</td>
                <td>${post.modifiedDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="./layout/footer.jsp" %>