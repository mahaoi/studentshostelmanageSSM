<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--
  Created by IntelliJ IDEA.
  User: guoguo
  Date: 2020/3/8
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <title>User Login</title>
</head>
<script>
    $(function () {
        $("#login").click(function () {
            //判断用户名和密码是否为空
            if (($("#username").val()!="") && ($("#password").val()!="")) {
                $("#null-username-password").text("");
                //请求
                $.ajax({
                    url : "login/log",
                    type : "POST",
                    async : true,
                    dataType : "json",
                    data : {
                        username : $("#username").val(),
                        password : $("#password").val()
                    },
                    success : function(result) {
                        if (result=="0") {
                            alert("登录成功！");
                        }else {
                            alert("登录失败！");
                        }
                    }
                });
            }else {
                $("#null-username-password").text("用户名或密码不能为空").css({"color":"red"});
            }
        });
    });
</script>
<body>
<div>
    <from>
        姓名：<input type="text" name="username" id="username"/><br/>
        密码：<input type="password" name="password" id="password"/><br/>
        <span id="null-username-password"></span><br/>
        <a href="register.jsp">还没有账号，去注册！</a><br/>
        <input type="submit" id="login" value="Sign in"/><br/>
    </from>
</div>
</body>
</html>
