/**
 * 显示学生数据
 */
function showStudentTable() {
    $("#stuInfo").addClass("clkFontColor").parent().siblings().children().removeClass("clkFontColor");
    hideAll();//调用方法隐藏所有盒子
    //清空盒子
    $("#showStudentTable").empty();
    $("#showStudentTable").css("display","block");
    var tablehead = "<table width='100%'>\n" +
        "    <thead>\n" +
        "    <tr>\n" +
        "        <th>学号</th>\n" +
        "        <th>姓名</th>\n" +
        "        <th>性别</th>\n" +
        "        <th>专业</th>\n" +
        "        <th>班级</th>\n" +
        "        <th>电话</th>\n" +
        "        <th>操作</th>\n" +
        "    </tr>\n" +
        "    </thead>\n" +
        "    <tbody id=\"stulist\">\n" +
        "    </tbody>\n" +
        "</table>";
    $("#showStudentTable").append(tablehead);
    //请求数据
    $.ajax({
        url : "stu/findall",
        type : "get",
        dataType : "json",
        success : function(result) {
            console.log(result);
            $.each(result, function (n, value) {
                // alert(n + ' ' + value);
                var trs = "<tr><td>" + value.id + "</td>" +
                            "<td>" + value.name + "</td>" +
                            "<td>" + value.sex + "</td>" +
                            "<td>" + value.major + "</td>" +
                            "<td>" + value.classes + "</td>" +
                            "<td>" + value.phone + "</td>" +
                            "<td><button onclick='up("+value.id+")'>更新</button><button onclick='del("+value.id+")'>删除</button></td></tr>";
                $("#stulist").append(trs);
                //设置文本居中
                $("th,td").css("text-align","center");
            });
        }
    });
}
/**
 * 删除学生
 */
function del(id) {
    if(confirm("您确定删除吗")){
        $.ajax({
            url : "stu/del",
            type : "post",
            data : {id : id},
            success : function() {
                alert("删除成功！");
            }
        });
    }
    showStudentTable();
}
/**
 * 更新学生信息
 */
function up(id) {
    $.ajax({
        url : "stu/up",
        type : "post",
        data : {id : id},
        success : function() {
            showStudentTable();
        },
        error : function () {
            alert("功能完善中~~~");
        }
    });
}
/**
 * 显示宿舍数据
 */
function showRoomTable() {
    $("#roomInfo").addClass("clkFontColor").parent().siblings().children().removeClass("clkFontColor");
    hideAll();//调用方法隐藏所有盒子
    //清空盒子
    $("#showRoomTable").empty();
    $("#showRoomTable").css("display","block");
    var tablehead = "<table width='100%'>\n" +
        "    <thead>\n" +
        "    <tr>\n" +
        "        <th>宿舍编号</th>\n" +
        "        <th>可入住人数</th>\n" +
        "        <th>已入住人数</th>\n" +
        "        <th>剩余入住人数</th>\n" +
        "        <th>密码</th>\n" +
        "        <th>备注</th>\n" +
        "        <th>操作</th>\n" +
        "    </tr>\n" +
        "    </thead>\n" +
        "    <tbody id=\"roomlist\">\n" +
        "    </tbody>\n" +
        "</table>";
    $("#showRoomTable").append(tablehead);
    //请求数据
    $.ajax({
        url : "room/findAllRoom",
        type : "get",
        dataType : "json",
        success : function(result) {
            console.log(result);
            $.each(result, function (n, value) {
                // alert(n + ' ' + value);
                if (value.remarks == null){
                    value.remarks = "无";
                }
                var trs = "<tr><td>" + value.roomid + "</td>" +
                    "<td>" + value.in + "</td>" +
                    "<td>" + value.ining + "</td>" +
                    "<td>" + value.surplus + "</td>" +
                    "<td>" + value.password + "</td>" +
                    "<td>" + value.remarks + "</td>" +
                    "<td><button onclick='moreInfo(\""+value.roomid+"\")'>详情</button><button onclick='update("+value.roomid+")'>更新</button><button onclick='delete("+value.id+")'>删除</button></td></tr>";
                $("#roomlist").append(trs);
                //设置文本居中
                $("th,td").css("text-align","center");
            });
        }
    });
}

/**
 * 显示宿舍入住详情
 */
function moreInfo(roomid) {
    //弹出div
    var dia = document.getElementById('dia');
    dia.style.display = (dia.style.display == 'none') ? 'block' : 'none';
    //清楚无用子节点
    $("#roomInfoBody").empty();
    //查询宿舍具体信息
    $.ajax({
        url : "room_stu/findAllStu",
        type : "post",
        data : {
            roomid : roomid
        },
        dataType : "json",
        success : function(result) {
            //设置清单头部信息  宿舍编号和宿舍已入住人数
            $("#roomId").text("宿舍:"+roomid);
            $("#roomIn").text("已入住"+result.length+"人");
            $.each(result, function (n, value) {
                // alert(n + ' ' + value);
                var students = value.studentInfos;
                moreInfo2(students);
                console.log(students);
            });
        },
        error : function () {
            alert("error");
        }
    });
}
function moreInfo2(result) {
    $.each(result, function (n, value) {
        // alert(n + ' ' + value);
        var trs = "<tr><td>" + value.id + "</td><td>"+value.name+"</td></tr>";
        $("#roomInfoBody").append(trs);
    });
    $("#ok").click(function () {
        var dia = document.getElementById('dia');
        dia.style.display = 'none';
    });
}



























/**
 * 隐藏所有盒子
 */
function hideAll() {
    $("#showLogo").css("display","none");
    $("#showStudentTable").css("display","none");
    $("#showRoomTable").css("display","none");
}

/**
 * 彩蛋：点击果果妞妞播放bgm
 */
function playBgm() {
    $("#voice").play();
}


