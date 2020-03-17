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
    <title>Students Hostel Manage</title>
    <style>
        #header {
            background-color:white;
            color:white;
            /*text-align:center;*/
            padding:5px;
        }
        #nav {
            line-height:50px;
            background-color:#eeeeee;
            height:580px;
            width:220px;
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
    </style>
</head>
<body>
<div id="header">
    <a>
        <img src="images/logo.png" style="width: 229px;height: 63.85px;"/>
    </a>
    <div>
        <iframe width="450" scrolling="no" height="18" frameborder="0" allowtransparency="true" src="//i.tianqi.com/index.php?c=code&id=1&color=%230070C0&icon=1&wind=1&num=2&site=12"></iframe>

    </div>
</div>

<div id="nav">
    <a href="login.jsp">Sign in</a><br/>
    <a href="list.jsp">list</a><br/>
    <a href="testlist.jsp">page</a><br/>
    <a href="tan.jsp">tanchuang</a><br/>
</div>

<div id="section">
    <h2>London</h2>
    <p>
        London is the capital city of England. It is the most populous city in the United Kingdom,
        with a metropolitan area of over 13 million inhabitants.
    </p>
    <p>
        Standing on the River Thames, London has been a major settlement for two millennia,
        its history going back to its founding by the Romans, who named it Londinium.
    </p>
</div>

<div id="footer">
    Copyright ? 果果妞妞
</div>
</body>
</html>
