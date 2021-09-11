<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <style>
        body {
            background-color: pink;
        }
        span{
            color:red;
        }
    </style>

    <script type="text/javascript">
        //js代码
        function clearLoginMsg(){
            var spanEle = document.getElementById("s");
            spanEle.innerHTML ="";
        }
    </script>

</head>
<body>
<h1>欢迎登陆</h1>
<form action="login" method="post">
    用户名称：<input type="text" name="username" onfocus="clearLoginMsg();" />
    <br />
    用户密码：<input type="password" name="password" onfocus="clearLoginMsg();"/>
    <br />
    <input type="submit" value="login" />
    <br />
    <!-- EL表达式默认会从 pageScope requestScope  sessionScope  applicationScope中查找数据 -->
    <span id="s">${requestScope.login_msg}</span>
</form>
</body>
</html>