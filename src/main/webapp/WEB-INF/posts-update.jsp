<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>

<%@ include file="./layout/header.jsp" %>
<h1>게시글 수정</h1>

<div class="col-md-12">
    <div class="col-md-4">
        <form action="/posts/update/${post.id}" method="post">
            <div class="form-group">
                <label for="title">글 번호</label>
                <input type="text" class="form-control" id="id" name="id" value="${post.id}"
                       readonly>
            </div>
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" class="form-control" id="title" name="title"
                       value="${post.title}">
            </div>
            <div class="form-group">
                <label for="author"> 작성자 </label>
                <input type="text" class="form-control" id="author" name="author"
                       value="${post.author}"
                       readonly>
            </div>
            <div class="form-group">
                <label for="content"> 내용 </label>
                <textarea class="form-control" name="content"
                          id="content">${post.content}</textarea>
            </div>
            <input type="submit" class="btn btn-primary" id="btn-update">게시글 수정</input>
        </form>
        <a href="/" role="button" class="btn btn-secondary">목록으로</a>

    </div>
</div>

<%@ include file="./layout/footer.jsp" %>