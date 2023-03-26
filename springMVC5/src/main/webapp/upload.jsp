<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<%--注意表单中的enctype="multipart/form-data" method="post"--%>
<form action="${pageContext.request.contextPath}/student/select11" enctype="multipart/form-data" method="post">
    <label>
        name:
        <input type="text" name="fileName">
    </label><br>
    file:<input type="file" name="uploadFile"><br>
    <input type="submit" value="submit">
</form>
</body>
</html>
