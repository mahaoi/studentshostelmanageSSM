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
<style>
    .page {
        height: 34px;
        line-height: 34px;
    }
    .page a {
        display: inline-block;
        border: 1px solid #ededed;
        padding: 0 12px;
        color: #3e3e3e;
        font-size: 14px;
        font-family: tahoma,simsun;
        text-decoration: none;
    }
    .page a:hover {
        color: #f40;
        border-color: #f40;
    }
    .page .active,.page .active:hover {
        color: #fff;
        background: #f40;
        border: solid 1px #f40;
    }
</style>
<script>
    $(function () {
       $("#findall").click(function () {
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
           //这里通过ajax查询到总记录数totalCount
           //设定每页显示记录数pageSize,算出总页数totalPageNum
           js_method(1,10);
       });
    });

    /**
     * 传入当前页和和总页数
     */
    function js_method(currentPageNum,totalPageNum) {
        currentPageNum = Number(currentPageNum);
        var startPageNum = currentPageNum - 2; //起始页
        var endPageNum = currentPageNum + 2; //结束页
        $("#pag").text("") //清空导航条
        if (startPageNum <= 0) {
            startPageNum = 1
            endPageNum = startPageNum + 4
        }
        if (endPageNum > totalPageNum) {
            endPageNum = totalPageNum
            startPageNum = endPageNum - 4
        }

        if (currentPageNum != 1) {
            $("#pag").append(
                "<a href='javascript:void(0);' onclick='js_method(1,"+totalPageNum+")' >首页</a>"
            )
            $("#pag").append(
                "<a href='javascript:void(0);' onclick='js_method($(\".active\").text()-1,"+totalPageNum+")' id='prePageNum'>&laquo;</a>"
            )
        }
        for (var i = 0; i <= endPageNum; i++) {
            if (i >= startPageNum) {

                if (i == currentPageNum) {
                    var ele = "<a href='javascript:void(0);' class='active' onclick='js_method($(this).text(),"+totalPageNum+")' >" +
                        i + "</a>"
                } else {
                    var ele = "<a href='javascript:void(0);' onclick='js_method($(this).text(),"+totalPageNum+")' >" + i + "</a>"
                }
            }
            $("#pag").append(ele)
        }
        if (currentPageNum != totalPageNum) {
            $("#pag").append(
                "<a href='javascript:void(0);' onclick='js_method(Number($(\".active\").text())+1,"+totalPageNum+")' id='prePageNum' rel='pre'>&raquo;</a>"
            )
            $("#pag").append(
                "<a href='javascript:void(0);' onclick='js_method(10,"+totalPageNum+")' >尾页</a>"
            )
        }
        //在这里通过ajax去查询当前页的数据
    }
</script>
<body>
<div align="center">
    <button id="findall">list</button>
</div>
<div id="showtable" align="center">
<%--展示数据的表格盒子--%>
</div>
<!--分页导航条 -->
<div class="page" id="pag" align="center">
    <!--<a href="javascript:void(0);" onclick="js_method($(this).html())">4</a> -->
</div>
</body>
</html>
