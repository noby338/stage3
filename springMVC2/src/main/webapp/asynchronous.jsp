<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%--    <script src="js/jquery-3.6.0.js"></script>--%>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.get("<c:url value="/user/asynchronous.do"/>",
                    null,
                    function (result) {
                        let newInfo = result.eid + result.ename;
                        $("#btn").after(newInfo)
                    })
            })

            $("#btn2").click(function () {
                $.ajax({
                    type:"POST",
                    url:"user/requestBody.do",
                    contentType:"application/json;charset=utf-8",
                    data:'{"eid":"10","ename":"noby","dep":{"did":"100","dname":"sale"}}',
                    success:function(result) {
                        console.log(result)
                        let newInfo = result.eid + result.ename;
                        $("#btn2").after(newInfo)
                    },
                    error:function() {
                        console.log("error")
                    }
                });

            })

        })
    </script>
</head>
<body>
<input type="button" value="asynchronous" class="btn btn-info" id="btn"><br>
<input type="button" value="requestBody" class="btn btn-info" id="btn2">

</body>
</html>
