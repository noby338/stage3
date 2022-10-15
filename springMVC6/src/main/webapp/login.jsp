<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<%--图片将会被拦截--%>
<img src="${pageContext.request.contextPath}/img/photo.jpg" width="900" height="700">
<form action="http://localhost:8080/springMVC6/user/login" method="get">
    用户名：<input type="text" name="username" value="noby"><br>
    密码：<input type="text" name="password" value="123"><br>
    <input type="submit" value="submit">
</form>
</body>
</html>
