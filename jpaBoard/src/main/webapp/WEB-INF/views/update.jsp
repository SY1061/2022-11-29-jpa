<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>강의 수정</title>
</head>
<body>
<form method="post", action="/update/${post.getId()}">
    Content <textarea name="content" rows="10" cols="80"></textarea><br />
    <input type="submit" value="수정">
</form>
</body>
</html>
