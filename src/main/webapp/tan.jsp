<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head id="Head1" runat="server">
    <title>弹窗表单</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
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

        body {
            background:url(images/bg.jpg);//背景路径
            background-size:100%;//填充
            /*background-repeat:no-repeat;//无重复*/
            /*background-attachment: fixed;//固定*/
        }
    </style>
</head>
<body>
<a id="testtan">分配宿舍</a>
<div class="wrap-box" id="dia" style="display: none;"><!--最外层包裹框，背景图片很鲜艳亮眼position:fixed-->
    <div class='login-box'><!--登录表单框部分position:fixed-->
<%--        <button id="btu">获取可分配宿舍号</button><br/>--%>
        <select id="updateRoom" style="margin-left: 200px;">
            <option>请选择宿舍号</option>
        </select>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    $(function () {
       $("#testtan").click(function () {
           //弹出div
           var dia = document.getElementById('dia');
           dia.style.display = (dia.style.display == 'none') ? 'block' : 'none';
           //清楚无用子节点
           $("#updateRoom").empty().append("<option>请选择宿舍号</option>");
           //查询拥有空床位的宿舍号
           $.ajax({
               url : "login/updateRoom",
               type : "get",
               dataType : "json",
               success : function(result) {
                   $.each(result, function (n, value) {
                       // alert(n + ' ' + value);
                       if (value.nullroom > 0){
                           var trs = "<option value='" + value.room + "'>" + value.room + "</option>";
                           $("#updateRoom").append(trs);
                       }
                   });
               },
               error : function () {
                   alert("error");
               }
           });
       });
    });
</script>
