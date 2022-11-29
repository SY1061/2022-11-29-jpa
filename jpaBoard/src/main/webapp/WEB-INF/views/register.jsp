<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>강의 등록</title>
</head>
<body>
<form method="post", action="/register">
    Title <input type="text" name="title"><br />
    Content <textarea name="content" rows="10" cols="80"></textarea><br />
    <input type="submit" value="등록">
</form>
</body>
</html>
