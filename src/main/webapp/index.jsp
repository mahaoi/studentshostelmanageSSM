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
<body>
<%--头部导航栏--%>
<div id="header">
    <a>
        <img src="images/logo.png" style="width: 229px;height: 63.85px;"/>
    </a>
<%--    <iframe width="450" scrolling="no" height="18" frameborder="0" allowtransparency="true" src="//i.tianqi.com/index.php?c=code&id=1&color=%230070C0&icon=1&wind=1&num=2&site=12"></iframe>--%>
</div>
<%--侧边导航栏--%>
<div id="nav">
    <ul>
        <li>
            <a href="index.jsp">Home</a>
        </li>
        <li>
            <a onclick="showStudentTable()" id="stuInfo">Student Info</a>
        </li>
        <li>
            <a onclick="showRoomTable()" id="roomInfo">Room Info</a>
        </li>
        <li>
            <a>test</a>
        </li>
        <li>
            <a href="testlist.jsp">page</a>
        </li>
        <li>
            <a href="tan.jsp">tanchuang</a>
        </li>
        <li>
            <a href="login.jsp">Sign in</a>
        </li>
    </ul>
</div>
<%--信息显示的盒子--%>
<div id="section">
    <div id="showLogo" style="display: block;">
        <%--  显示logo  --%>
        <img src="images/8.png" width="100%"/>
    </div>
    <div id="showStudentTable" style="display: none;"><%--  显示学生数据  --%></div>
    <div id="showRoomTable" style="display: none;"><%--  显示宿舍数据  --%></div>
    <div class="wrap-box" id="dia" style="display: none;"><!--最外层包裹框，背景图片很鲜艳亮眼position:fixed-->
        <div class='login-box'><!--表单框部分position:fixed-->
            <table border="0" style="margin-left: 150px;">
                <thead align="center">
                    <tr><th colspan="2">================</th></tr>
                    <tr><th colspan="2">宿舍入住详情</th></tr>
                    <tr><th colspan="2">================</th></tr>
                    <tr>
                        <td id="roomId"></td>
                        <td id="roomIn"></td>
                    </tr>
                    <tr><th colspan="2">----------------------------</th></tr>
                    <tr>
                        <td>学号</td>
                        <td>姓名</td>
                    </tr>
                    <tr><th colspan="2">----------------------------</th></tr>
                </thead>
                <tfoot align="center">
                    <tr><th colspan="2">----------------------------</th></tr>
                    <tr><td></td><td><a id="ok" style="color: aqua">确定</a></td></tr>
                    <tr><th colspan="2">================</th></tr>
                </tfoot>
                <tbody align="center" id="roomInfoBody"></tbody>
            </table>
        </div>
    </div>
</div>
<%--下边版权信息--%>
<div id="footer">
    Copyright ? 2020 <a onclick="playBgm()">果果妞妞</a>
</div>
<%--<audio id="voice" src="music/bgm.mp3"></audio>--%>
<%--<embed src="bgm,mp3" autostar="true" hidden="true"/>--%>
<%--<embed src="musics/bgm.mp3" hidden="true" autostart="true" loop="true">--%>
</body>
</html>
<style type="text/css">
    #dia
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
