<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/16
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.js"></script>
    <script type="text/javascript">
        function confirm_user() {
            $.ajax({});
        }
    </script>
</head>
<body>
<form:form action="/user/register.action" method="post" commandName="t_user" role="form">

    <div class="form-group">
        <label for="userPhone">手机号:</label>
        <input type="text" class="form-control" id="userPhone" name="userPhone" placeholder="请输入手机号"/>
    </div>

    <div class="form-group">
        <label for="nickName">昵称:</label>
        <input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入昵称"/>
    </div>

    <div class="form-group">
        <label for="userPwd">密码:</label>
        <input type="text" class="form-control" id="userPwd" name="userPwd" placeholder="请输入密码"/>
    </div>
    <div class="form-group">
        <button onclick="confirm_user()" type="submit" class="btn btn-sm btn-success">注册</button>
    </div>
</form:form>


</body>
</html>
