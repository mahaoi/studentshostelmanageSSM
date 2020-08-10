<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link type="text/css" rel="styleSheet"  href="css/main.css" />
    <script src="js/main.js"></script>
    <title>Students Hostel</title>
</head>
<script>
    $(function(){
        var username = '<%= session.getAttribute("room")%>';
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
        <div id="perInfo">
            <a>
                <button id="userName">你好：<%=request.getSession().getAttribute("room") %></button>
            </a>
            <a>
                <button onclick="upUserPass('<%=request.getSession().getAttribute("room") %>')">修改密码</button>
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
            <a onclick="Info('<%=request.getSession().getAttribute("room") %>')" id="userRoomInfo">Info</a>
        </li>
        <li>
            <a onclick="findOldRepair('<%=request.getSession().getAttribute("room") %>')" id="userRepair">Repair</a>
        </li>
    </ul>
</div>
<%--信息显示的盒子--%>
<div id="section">
    <%--  显示logo  --%>
    <div id="showData" style="display: block;"><img src="images/0.png" width="100%"/></div>
    <div id="showRepair" style="display: block;">
        <a style="color: red">报修信息提交处</a>
        <textarea cols="100" rows="6" style="OVERFLOW : hidden"></textarea>
        <input type="submit" onclick="subRepair('<%=request.getSession().getAttribute("room") %>')" value="提交"/>
    </div>
</div>
<%--下边版权信息--%>
<div id="footer">
    Copyright © 2020 By <a id="caiDan">果果妞妞</a> & 银河领主小浩. All rights reserved.
</div>
<script>
    $("#caiDan").focus(caiDan());
</script>
</body>
</html>
