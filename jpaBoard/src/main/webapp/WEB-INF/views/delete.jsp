<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시물 삭제</title>
</head>
<body>
<form method="post", action="/delete/${post.getId()}">
    ID  <input type="text" name="id"><br />
    <input type="submit" value="삭제">
</form>
</body>
</html>
