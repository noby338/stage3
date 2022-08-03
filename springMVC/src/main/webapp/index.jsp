<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%--    <script>--%>

<%--        $(function(){--%>
<%--            $.get("<c:url value="/EmpServlet"/>",--%>
<%--                method="init",--%>
<%--            function (result) {--%>
<%--                let newTr;--%>
<%--                $.each(result,function () {--%>

<%--                    newTr += `<tr>--%>
<%--                                    <td>`+this.eid+`</td>--%>
<%--                                    <td>`+this.ename+`</td>--%>
<%--                                    <td>`+this.dep.dname+`</td>--%>
<%--                                    <td><input type="button" value="del" id=`+this.eid+`/></td>--%>
<%--                                </tr>`--%>
<%--                })--%>
<%--                $("#add_btn").before(newTr)--%>
<%--            },"json")--%>

<%--            $("#add_btn").click(function () {--%>
<%--                newTr = `<tr class="new_info">--%>
<%--                                    <td></td>--%>
<%--                                    <td><input type="text"/></td>--%>
<%--                                    <td><input type="text"/></td>--%>
<%--                                </tr>`--%>
<%--                $(this).before(newTr)--%>
<%--            })--%>
<%--        })--%>
<%--    </script>--%>
</head>
<body>
<h1>${msg}</h1>
<%--<input type="button" value="refresh" class="btn btn-info">--%>
<%--<table class="table table-striped table-hover table-bordered table-primary" id="contend">--%>
<%--    <tr>--%>
<%--        <th>eid</th>--%>
<%--        <th>ename</th>--%>
<%--        <th>depname</th>--%>
<%--        <th>del</th>--%>
<%--    </tr>--%>
<%--    <tr id="add_btn">--%>
<%--        <td colspan="3" class=" text-center"><span class="glyphicon glyphicon-plus"></span></td>--%>
<%--    </tr>--%>
<%--</table>--%>
</body>
</html>
