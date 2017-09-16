<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/14
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <h1>登录页面</h1>
    <form action="/login.action" method="post">
        手机号:<input type="text" name="userPhone">
        <p>
            密码:<input type="text" name="userPwd">
        <p>
            <input type="submit" value="登录">
    </form>

    <a href="/user/register" type="button" class="btn btn-sm btn-success">注册</a>


</head>
<body>

</body>
</html>
