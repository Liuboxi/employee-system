<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 导入JSTL标签 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>ListPage</title>

    <!-- 引入jQuery -->
    <script type="text/javascript" src="scripts\jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //给删除的<a>动态绑定事件
            $(".del").click(function () {
                //确认是否要删除
                var flag = window.confirm("是否确定删除？");
                //取消<a>的默认行为
                if (!flag) {
                    return false;
                }

                //this:当前点击的dom对象，获取点击的超连接的href的值
                var href = $(this).attr("href");

                //将href的值设置到表单的action上，并提交
                $("form").attr("action", href).submit();

                //取消<a>的默认行为
                return false;

            });
        });

    </script>

</head>
<body>

<form action="" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>

<h1 align="center">员工信息列表</h1>
<table align="center" border="1px" width="70%" cellspacing="1px">
    <tr>
        <th>ID</th>
        <th>LastName</th>
        <th>Email</th>
        <th>Gender</th>
        <th>DeptID</th>
        <th>DeptName</th>
        <th>Operation</th>
    </tr>
    <c:forEach items="${emps}" var="emp">
        <tr align="center">
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender}</td>
            <td>${emp.dept.id}</td>
            <td>${emp.dept.deptName}</td>
            <td>
                <a href="emp/${emp.id}">Edit</a>
                &nbsp; &nbsp;
                <a class="del" href="emp/${emp.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h3 align="center"><a href="emp">Add New Emp</a></h3>

</body>
</html>
