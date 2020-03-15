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
    <title>Students Hostel Manage</title>
    <style>
        #header {
            background-color:white;
            color:white;
            padding:5px;
        }
        #nav {
            line-height:50px;
            background-color:#eeeeee;
            height:570px;
            width:220px;
            text-align:center;
            float:left;
            padding:5px;
        }
        #section {
            width:1200px;
            float:left;
            padding:10px;
        }
        #footer {
            background-color:black;
            color:white;
            clear:both;
            text-align:center;
            padding:5px;
        }
        html,body{width:100% }
    </style>
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
            <a href="login.jsp">Sign in</a>
        </li>
        <li>
            <a onclick="showTable()">Student List</a>
        </li>
        <li>
            <a href="testlist.jsp">page</a>
        </li>
        <li>
            <a href="tan.jsp">tanchuang</a>
        </li>
    </ul>
</div>
<%--信息显示的盒子--%>
<div id="section">
    <div id="showLogo" style="display: block;">
        <%--  显示logo  --%>
        <img src="images/8.png" width="100%"/>
    </div>
    <div id="showTable" style="display: none;"><%--  显示表格数据  --%></div>
</div>
<%--下边版权信息--%>
<div id="footer">
    Copyright ? 2020 果果妞妞
</div>
</body>
</html>
