<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script>
        $(function(){
            $.get("<c:url value="/empServlet"/>",
                {"method": "init"},
            function (result) {
                let newTr;
                $.each(result,function () {
                    newTr += `<tr>
                                    <td>\${this.id}</td>
                                    <td>\${this.name}</td>
                                    <td>\${this.dep.name}</td>
                                </tr>`
                })
                $("#add_btn").before(newTr)
            },"json")

        })
    </script>
</head>
<body>
<table class="table table-striped table-hover table-bordered table-primary" id="contend">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>depName</th>
    </tr>
    <tr id="add_btn">
        <td colspan="3" class=" text-center"><span class="glyphicon glyphicon-plus"></span></td>
    </tr>
</table>
</body>
</html>
