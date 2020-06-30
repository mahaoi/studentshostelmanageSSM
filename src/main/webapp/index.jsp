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

<body>
<%--头部导航栏--%>
<div id="header">
    <nav>
        <a>
            <img src="images/logo.png" style="width: 229px;height: 63.85px;"/>
        </a>
        <a>
            <button id="addVisitor" onclick="addVisit()">来访登记</button>
        </a>
        <a>
            <button id="addStu" onclick="addStu()">学生添加</button>
        </a>
        <a>
            <button id="addRoom" onclick="addRoom()">寝室添加</button>
        </a>
        <a>
            <button id="addMan" onclick="addMan('<%=request.getSession().getAttribute("user") %>')">管理员添加</button>
        </a>
        <a>
            <input id='findBy' placeholder='请输入查询内容'/>
        </a>
        <div id="perInfo">
            <a>
                <iframe width="450" scrolling="no" height="18" frameborder="0" allowtransparency="true" src="//i.tianqi.com/index.php?c=code&id=1&icon=1&wind=1&num=1&site=12"></iframe>
            </a>
            <a>
                <button id="adminName">你好：<%=request.getSession().getAttribute("user") %></button>
            </a>
            <a>
                <button onclick="upAdminPass('<%=request.getSession().getAttribute("user") %>')">修改密码</button>
            </a>
            <a>
                <button onclick="logout()">退出</button>
            </a>
        </div>
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
            <a onclick="repairTable()" id="repairInfo">Repair Info</a>
        </li>
        <li>
            <a onclick="showManagerInfo('<%=request.getSession().getAttribute("user") %>')" id="managerInfo">Manager Info</a>
        </li>
    </ul>
</div>
<%--信息显示的盒子--%>
<div id="section">
    <%--  显示logo  --%>
    <div id="showData" style="display: block;">
        <img src="images/0.png" width="100%"/><br><br><br><br><br><hr>
        <div>
            <ul style="list-style-type:square">
                <li>框架：SSM</li>
                <li>服务器环境：windows 10</li>
                <li>数据库版本：5.1.17</li>
                <li>maven：3.3.9</li>
                <li>tomcat：8.5.12</li>
                <li>github：</li>
            </ul>
        </div>
    </div>
    <div id="showRepair" style="display: block;"></div>
    <%--  宿舍详情弹窗  --%>
    <div class="wrap-box" id="dia" style="display: none;"><!--最外层包裹框，背景图片很鲜艳亮眼position:fixed-->
        <div class='login-box'><!--表单框部分position:fixed-->
            <table border="0" style="margin-left: 20px;">
                <thead align="center">
                    <tr><th colspan="6">======================================</th></tr>
                    <tr><th colspan="6">宿舍入住详情</th></tr>
                    <tr><th colspan="6">======================================</th></tr>
                    <tr>
                        <td id="roomId" colspan="2"></td>
                        <td></td><td></td>
                        <td id="roomIn" colspan="2"></td>
                    </tr>
                    <tr><th colspan="6">------------------------------------------------------------</th></tr>
                    <tr>
                        <td colspan="2">学号</td>
                        <td colspan="2">专业</td>
                        <td>姓名</td>
                        <td>操作</td>
                    </tr>
                    <tr><th colspan="6">------------------------------------------------------------</th></tr>
                </thead>
                <tfoot align="center">
                    <tr><th colspan="6">------------------------------------------------------------</th></tr>
                    <tr><td><a id="ok" style="color: aqua">确定</a></td></tr>
                    <tr><th colspan="6">======================================</th></tr>
                </tfoot>
                <tbody align="center" id="roomInfoBody" style="height: auto;overflow-y: visible"></tbody>
            </table>
        </div>
    </div>
    <%--  弹窗  --%>
    <div class="wrap-box" id="diaStu" style="display: none;"><!--最外层包裹框，背景图片很鲜艳亮眼position:fixed-->
        <div class='login-box'>
            <select id="update" style="margin-left: 200px;"></select>
        </div>
    </div>
</div>
<%--下边版权信息--%>
<div id="footer">
    Copyright © 2020 By <a id="caiDan">果果妞妞</a> & 银河领主小浩. All rights reserved.
</div>
<script>
    $("#caiDan").focus(caiDan());
</script>
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

        //加载报修信息
        //清空盒子
        $("#showRepair").empty();
        var tablehead = "<table width='100%'>\n" +
            "    <thead>\n" +
            "    <tr><th colspan='2' style='color: red'>待办</th></tr>\n" +
            "    <tr>\n" +
            "        <th>寝室</th>\n" +
            "        <th>内容</th>\n" +
            "    </tr>\n" +
            "    </thead>\n" +
            "    <tbody id=\"repairList\">\n" +
            "    </tbody>\n" +
            "</table>";
        $("#showRepair").append(tablehead);
        //请求数据
        $.ajax({
            url : "repair/findAll",
            type : "get",
            dataType : "json",
            success : function(result) {
                console.log(result);
                $.each(result, function (n, value) {
                    if (value.repairState != "0"){
                        var trs = "<tr><td>" + value.repairName + "</td>" +
                            "<td>" + value.repairText +"</td></tr>";
                        $("#repairList").append(trs);
                        //设置文本居中
                        $("th,td").css("text-align","center");
                    }
                });
            }
        });


    });
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
        top: 200px;
        left: 50%;
        width: 500px;
        height: 635px;
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
