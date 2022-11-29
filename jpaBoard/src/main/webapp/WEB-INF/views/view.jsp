<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시물 상세 조회</title>
    <style>
        table, div {
            width : 70%;
            margin: auto;
        }

        table, td, th{
            border-collapse: collapse;
            border : 1px solid black;
        }

        th, td{
            text-align: center;
        }

        div {
            text-align : center;
        }
    </style>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <th>게시물 번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록 날짜</th>
            <th>수정자</th>
            <th>수정 날짜</th>
        </tr>

            <tr>
                <td>${post.getId()}</td>
                <td>${post.getTitle()}</td>
                <td>${post.getUsername()}</td>
                <td>${post.getTimestamp()}</td>
                <td>${post.getModifyName()}</td>
                <td>${post.getModifyTime()}</td>
            </tr>
    </table>
    <div><textarea rows="10" cols="125" readonly>${post.getContent()}</textarea></div>
</form><br />

<c:if test="${loginUsername eq post.getUsername() or loginUsername eq 'manager'}">
    <form method="get" action="/update/${post.getId()}">
        <input style="margin-left: 220px" type="submit"  value="수정하기">
    </form>
</c:if>

<c:if test="${loginUsername eq post.getUsername() or loginUsername eq 'manager'}">
    <form method="get" action="/delete/${post.getId()}">
        <input style="margin-left: 220px" type="submit" value="삭제하기">
    </form>
</c:if>

<h1 style="margin-left: 220px">댓글 등록</h1>
<form method="post", action="/comment/register/${post.getId()}">
    <div><textarea name="commentContent" rows="10" cols="125"></textarea></div><br />
    <input style="margin-left: 220px" type="submit" value="댓글 등록">
</form>

<h1 style="margin-left: 220px">댓글</h1>
<table>
    <tr>
        <th>댓글 작성자</th>
        <th>댓글 내용</th>
        <th>등록 날짜</th>
    </tr>

    <c:forEach var="item"  items="${commentRepositoryList}">
        <tr>
            <c:if test="${post.getId() eq item.getPostId()}">
                <td>${item.getUsername()}</td>
                <td>${item.getContent()}</td>
                <td>${item.getTimestamp()}</td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>
