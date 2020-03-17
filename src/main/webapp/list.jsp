<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--
  Created by IntelliJ IDEA.
  User: guoguo
  Date: 2020/3/10
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <title>Title</title>
</head>
<script>
    $(function () {
       $("#findall").click(function () {
           //清空盒子
           $("#showtable").empty();
           var tablehead = "<table border=\"1\">\n" +
               "    <thead>\n" +
               "    <tr>\n" +
               "        <th>sid</th>\n" +
               "        <th>username</th>\n" +
               "        <th>password</th>\n" +
               "        <th>phone</th>\n" +
               "    </tr>\n" +
               "    </thead>\n" +
               "    <tbody id=\"tablelist\">\n" +
               "    </tbody>\n" +
               "</table>";
           $("#showtable").append(tablehead);
           //请求数据
           $.ajax({
               url : "login/findall",
               type : "get",
               dataType : "json",
               success : function(result) {
                   $.each(result, function (n, value) {
                       // alert(n + ' ' + value);
                       var trs = "<tr><td>" + value.sid + "</td> <td>" + value.username + "</td> <td>" + value.password + "</td> <td>" + value.phone + "</td></tr>";
                       $("#tablelist").append(trs);
                   });
               }
           });
       });
    });
</script>
<body>
<button id="findall">list</button>
<br/><a id="test"></a>
<div id="showtable">
<%--展示数据的表格盒子--%>
</div>
</body>
</html>
