<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 导入springMVC表单标签库 -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- 导入jstl标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Update Emps</title>
</head>
<body>

<form:form action="${pageContext.request.contextPath }/emp" method="post" modelAttribute="employee">

    <!--
    判断是添加操作还是修改操作:
    根据回显的Employee对象的id值来判断: 如果有id就是修改,没有id就是添加操作
    -->
    <c:if test="${!empty employee.id }" var="flag">
        <!-- 修改操作 -->
        <form:hidden path="id"/>
        <!-- 隐藏PUT -->
        <input type="hidden" name="_method" value="PUT"/>

    </c:if>


    LastName:<form:input path="lastName"/>
    <br/>
    Email:<form:input path="email"/>
    <br/>
    Gender:<form:radiobuttons path="gender" items="${genders }"/>
    <br/>
    DeptName:<form:select path="dept.id" items="${depts }" itemLabel="deptName" itemValue="id"/>
    <br/>


    <c:if test="${!flag }">
        <input type="submit" value="ADD"/>
    </c:if>
    <c:if test="${flag }">
        <input type="submit" value="Edit">
    </c:if>


</form:form>

</body>
</html>
