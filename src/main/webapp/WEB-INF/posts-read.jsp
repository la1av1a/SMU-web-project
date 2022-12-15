<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>

<%@ include file="./layout/header.jsp" %>
<!DOCTYPE HTML>
<head>
</head>
<body>

</body>
<h1>게시글 읽기</h1>

<div class="col-md-12">
    <div class="col-md-4">
        <form>
            <div class="form-group">
                <label for="title">글 번호</label>
                <input type="text" class="form-control" id="id" value="${post.id}" readonly>
            </div>
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" class="form-control" id="title" value="${post.title}" readonly>
            </div>
            <div class="form-group">
                <label for="author"> 작성자 </label>
                <input type="text" class="form-control" id="author" value="${post.author}"
                       readonly>
            </div>
            <div class="form-group">
                <label for="content"> 내용 </label>
                <textarea class="form-control" id="content" readonly>${post.content}</textarea>
            </div>
        </form>
        <a href="/" role="button" class="btn btn-secondary">목록으로</a>
        <a href="/posts/update/${post.id}" type="button" class="btn btn-primary" id="btn-update">게시글
            수정</a>
        <form action="/posts/delete/${post.id}" method="post">
            <input type="submit" type="button" class="btn btn-danger"
                   id="btn-delete" value="삭제">
        </form>
    </div>
</div>

<%@ include file="./layout/footer.jsp" %>