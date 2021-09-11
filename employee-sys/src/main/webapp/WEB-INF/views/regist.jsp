<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>RegistPage</title>
    <style type="text/css">
        body {
            background: pink;
        }

        span {
            color: red;
        }

    </style>
    <script type="text/javascript" src="scripts/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">


    </script>

</head>
<body>
<form action="regist" method="post">
    用户名称：<input type="text" id="user" name="username"/> <br/>
    用户密码：<input type="password" id="password" name="password"/> <br/>
    确认密码：<input type="password" id="repassword" name="repassword"/> <br/>
    <input type="submit" value="regist"/> <br/>

    <span>${regist_msg }</span> <br/> <br/>

</form>
</body>
</html>