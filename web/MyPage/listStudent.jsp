<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>学生列表</title>
    <link href="css/style.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>

    <script>
        $(function () {
            $("ul.pagination li.disabled a").click(function () {
                return false;
            });
        });
    </script>
</head>

<body>

<div  class="listDIV">
    <table class="table table-striped table-bordered table-hover table-condensed">

        <caption>一共${studentCount}名学生</caption>
        <thead>
        <tr class="success">
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>生日</th>
            <th>成绩</th>

            <th>编辑</th>
            <th>删除</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${students}" var="s" varStatus="status">
            <tr>
                <td>${s.studentID}</td>
                <td>${s.name}</td>
                <td>${s.sex}</td>
                <td>${s.birthday}</td>
                <td>${s.score}</td>

                <td><a href="/CRUDStudent?methodName=editStu&id=${s.id}" ><span class="glyphicon glyphicon-edit"></span>编辑</a></td>
                <td><a href="/CRUDStudent?methodName=delStu&id=${s.id}"><span class="glyphicon glyphicon-edit"></span>删除</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


<div  class="addDIV">

    <div  class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">增加学生</h3>
        </div>
        <div class="panel-body">

            <form method="post" action="/CRUDStudent?methodName=addStu" role="form">
                <table class="addTable">
                    <tr>
                        <td>学号：</td>
                        <td><input type="text" name="studentID" id="studentID" placeholder="输入学号"></td>
                    </tr>
                    <tr>
                        <td>姓名：</td>
                        <td><input type="text" name="name" id="name" placeholder="输入名字"></td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td><input type="radio" class="radio radio-inline" name="sex" value="男"> 男
                            <input type="radio" class="radio radio-inline" name="sex" value="女"> 女
                        </td>
                    </tr>
                    <tr>
                        <td>生日：</td>
                        <td><input type="date" name="birthday" id="birthday" placeholder="输入生日"></td>
                    </tr>
                    <tr>
                        <td>成绩：</td>
                        <td><input type="text" name="score" id="score" placeholder="输入成绩"></td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit"  class="btn btn-success">提 交</button>
                        </td>

                    </tr>

                </table>
            </form>
        </div>
    </div>

</div>

</body>
</html>
