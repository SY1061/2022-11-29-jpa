<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>강의 목록</title>

    <style>
        table {
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
            <th>댓글 개수</th>
        </tr>
        <c:forEach var="item"  items="${PostRepositoryList}">
            <tr>
                <td>${item.getId()}</td>
                <td><a href="/view/${item.getId()}">${item.getTitle()}</a></td>
                <td>${item.getUsername()}</td>
                <td>${item.getTimestamp()}</td>
                <td>${item.getCommentCount()}</td>
            </tr>
        </c:forEach>
    </table>
</form>
<form method="get" action="/register">
    <input type="submit"  value="등록하기">
</form>
<br />

</body>
<br />
<a href="/logout">로그아웃</a><br />
</html>
