<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="./layout/header.jsp" %>

<div class="col-md-12">

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
        <c:forEach var="name" items="${postList}" varStatus="post">
            <tr>
                <td>${post.id}</td>
                <td><a href="/posts/update/{{id}}">${post.title}</a></td>
                <td>${post.title}</td>
                <td>${post.modifiedDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="./layout/footer.jsp" %>