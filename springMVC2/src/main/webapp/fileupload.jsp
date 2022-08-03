<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>fileupload</title>
</head>
<body>
<form action="/springMVC2/conNote/fileupload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="img"/><br>
    <input type="submit" value="upload"><br>
</form>
</body>
</html>
