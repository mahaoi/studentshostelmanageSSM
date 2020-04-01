<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--
  Created by IntelliJ IDEA.
  User: guoguo
  Date: 2020/4/1
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="js/index.js"></script>
</head>
<body>


<div class="materialContainer">
    <div class="box">
        <div class="title">登录</div>
        <div class="input">
            <label for="name">用户名</label>
            <input type="text" name="name" id="name">
            <span class="spin"></span>
        </div>
        <div class="input">
            <label for="pass">密码</label>
            <input type="password" name="pass" id="pass">
            <span class="spin"></span>
        </div>
        <span id="null-username-password"></span>
        <div class="button login">
            <button id="loginBtu">
                <span>登录</span>
                <i class="fa fa-check"></i>
            </button>
        </div>
        <a href="javascript:" class="pass-forgot">忘记密码？</a>
    </div>

    <div class="overbox">
        <div class="material-button alt-2">
            <span class="shape"></span>
        </div>
        <div class="title">注册</div>
        <div class="input">
            <label for="regname">用户名</label>
            <input type="text" name="regname" id="regname">
            <span class="spin"></span>
        </div>
        <div class="input">
            <label for="regpass">密码</label>
            <input type="password" name="regpass" id="regpass">
            <span class="spin"></span>
        </div>
        <div class="input">
            <label for="reregpass">确认密码</label>
            <input type="password" name="reregpass" id="reregpass">
            <span class="spin"></span>
        </div>
        <div class="button">
            <button id="regBtu">
                <span>注册</span>
            </button>
        </div>
    </div>

</div>



</body>

</html>
