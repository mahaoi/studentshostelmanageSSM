<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--
  Created by IntelliJ IDEA.
  User: guoguo
  Date: 2020/3/7
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<head>
<%--    <script type="text/javascript" src="js/jquery-1.12.4.js"/>--%>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <title>Register</title>
</head>
<script type="text/javascript">
    $(function(){
        //检测用户名是否已注册
        $("#username").blur(function(){
            var username = $("#username").val();
            $.ajax({
                url : "login/test",
                type : "POST",
                async : true,
                dataType : "json",
                data : {
                    username : username
                },
                success : function(result) {
                    if (result=="0"){
                        $("#error-name").text("用户已存在！").css({"color":"red"});
                        $("#username").focus(function () {
                            $("#error-name").text("");
                        });
                    }else{
                        $("#error-name").text("");
                    }
                }
            });
        });
        //判断两次输入密码是否相同
        $("#repeat-password").blur(function () {
            if ($("#password").val() != $("#repeat-password").val()){
                // alert("2次密码不相同")
                $("#error-password").text("两次密码不同！").css({"color":"red"});
                $("#repeat-password").val("");//清空输入框
            }else {
                $("#error-password").text("");
            }
        });
        //用户信息提交
        $("#register").click(function () {
            $.ajax({
                url : "login/add",
                type : "post",
                async : false, //此处是同步，不是异步
                // dataType : "text",
                data : {
                    username : $("#username").val(),
                    password : $("#password").val(),
                    phone : $("#phone").val()
                },
                success : function() {
                        alert("注册成功");
                        $("#userFrom").attr("action","login.jsp");
                        $("#userFrom").submit();
                },
                error : function () {
                    alert("error");
                }
            });
        });
    });
</script>
<body>
<div>
    <form id="userFrom" action="" method="post">
        姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="username" id="username"/><span id="error-name"></span><br/>
        密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="password"/><br/>
        确认密码：<input type="password" name="repeat-password" id="repeat-password"/><span id="error-password"></span><br/>
        联系方式：<input type="text" name="password" id="phone"/><br/>
        <input type="submit" id="register" value="提交"/><br/>
    </form>
</div>
</body>
</html>
