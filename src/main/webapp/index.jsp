<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--
  Created by IntelliJ IDEA.
  User: guoguo
  Date: 2020/3/9
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="js/main.js"></script>
    <link type="text/css" rel="styleSheet"  href="css/main.css" />
    <title>Students Hostel Manage</title>
</head>
<script>
    $(function(){
        var username = '<%= session.getAttribute("user")%>';
        if (username == 'null'){
            $("nav").empty().append("<a> <img src=\"images/logo.png\" style=\"width: 229px;height: 63.85px;\"/></a>" +
                "<a id='meg' style='margin-left: 30%'>你还未登录！3秒后跳转至登录！</a> ");
            $("#meg").css({"color":"red"});
            setTimeout(function () {
                $(location).attr("href","login.jsp");
            },3000);
        }
    });
</script>
<body>
<%--头部导航栏--%>
<div id="header">
    <nav>
        <a>
            <img src="images/logo.png" style="width: 229px;height: 63.85px;"/>
        </a>
        <a>
<%--            <iframe width="450" scrolling="no" height="18" frameborder="0" allowtransparency="true" src="//i.tianqi.com/index.php?c=code&id=1&color=%230070C0&icon=1&wind=1&num=2&site=12"></iframe>--%>
        </a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a>
            <button id="addVisitor" onclick="addVisit()">来访登记</button>
        </a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a>
            <button id="adminName"><%=request.getSession().getAttribute("user") %></button>
        </a>
        <a>
            <button onclick="logout()">退出</button>
        </a>
    </nav>
</div>
<%--侧边导航栏--%>
<div id="nav">
    <ul>
        <li>
            <a onclick="showLogo()" id="logo" class="clkFontColor">Home</a>
        </li>
        <li>
            <a onclick="showStudentTable()" id="stuInfo">Student Info</a>
        </li>
        <li>
            <a onclick="showRoomTable()" id="roomInfo">Room Info</a>
        </li>
        <li>
            <a onclick="UnallocatedStudentTable()" id="unallocatedSyu">Unallocated Student</a>
        </li>
        <li>
            <a onclick="showVisitorTable()" id="visitorInfo">Visitor Info</a>
        </li>
        <li>
            <a href="testlist.jsp">page</a>
        </li>
        <li>
            <a href="tan.jsp">tanchuang</a>
        </li>
        <li>
            <a href="login1.jsp">Sign in</a>
        </li>
    </ul>
</div>
<%--信息显示的盒子--%>
<div id="section">
    <%--  显示logo  --%>
    <div id="showData" style="display: block;"><img src="images/8.png" width="100%"/></div>
    <%--  宿舍详情弹窗  --%>
    <div class="wrap-box" id="dia" style="display: none;"><!--最外层包裹框，背景图片很鲜艳亮眼position:fixed-->
        <div class='login-box'><!--表单框部分position:fixed-->
            <table border="0" style="margin-left: 60px;">
                <thead align="center">
                    <tr><th colspan="4">============================</th></tr>
                    <tr><th colspan="4">宿舍入住详情</th></tr>
                    <tr><th colspan="4">============================</th></tr>
                    <tr>
                        <td id="roomId"></td>
                        <td></td><td></td>
                        <td id="roomIn"></td>
                    </tr>
                    <tr><th colspan="4">--------------------------------------------------</th></tr>
                    <tr>
                        <td>学号</td>
                        <td>专业</td>
                        <td>姓名</td>
                        <td>操作</td>
                    </tr>
                    <tr><th colspan="4">--------------------------------------------------</th></tr>
                </thead>
                <tfoot align="center">
                    <tr><th colspan="4">--------------------------------------------------</th></tr>
                    <tr><td></td><td></td><td></td><td><a id="ok" style="color: aqua">确定</a></td></tr>
                    <tr><th colspan="4">============================</th></tr>
                </tfoot>
                <tbody align="center" id="roomInfoBody"></tbody>
            </table>
        </div>
    </div>
    <%--  学生分配宿舍弹窗      --%>
    <div class="wrap-box" id="diaStu" style="display: none;"><!--最外层包裹框，背景图片很鲜艳亮眼position:fixed-->
        <div class='login-box'><!--登录表单框部分position:fixed-->
            <select id="update" style="margin-left: 200px;">
            </select>
        </div>
    </div>
</div>
<%--下边版权信息--%>
<div id="footer">
    Copyright ? 2020 <a id="caiDan">果果妞妞</a>
</div>
<script>
    $("#caiDan").focus(caiDan());
</script>
</body>
</html>






<style type="text/css">
    #dia, #diaStu
    {
        clear: left;
        float: left;
        background: rgba(0,0,0,0.5);
        z-index: 200;
        position: absolute;
        top: 50%;
        left: 50%;
        width: 500px;
        height: 400px;
        margin: -200px 0 0 -250px;
        border-radius: 10px;
        border-top-width: 10px;
        padding: 10px 10px 10px 10px;
    }

    .login-box::before{
        content:'';
        position:absolute;
        top:0;
        left:0;
        right:0;
        bottom:0;
        filter:blur(10px) contrast(.8);
        z-index:-1;
    }

    .wrap-box ,.login-box::before{
        background:url('images/bg.jpg') 0 / cover fixed;
    }
</style>
