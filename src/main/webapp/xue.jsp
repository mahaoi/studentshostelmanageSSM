<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--
  Created by IntelliJ IDEA.
  User: guoguo
  Date: 2020/3/9
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <title>Title</title>
</head>
<script type="text/javascript">
    $(function() {
        $("#btn").click(function () {
            alert("111");
            $("#audio").play();
        });
    });
</script>
<body>
<div style="margin-left: auto">
    <button id="btn">dianji</button>
    <audio id="audio" src="music/遇见-孙燕姿.mp3"></audio>
</div>
</body>
</html>
