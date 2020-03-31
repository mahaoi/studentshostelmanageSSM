/**
 * 显示学生数据
 */
function showStudentTable() {
    $("#stuInfo").addClass("clkFontColor").parent().siblings().children().removeClass("clkFontColor");
    //清空盒子
    $("#showData").empty();
    // $("#showStudentTable").css("display","block");
    var tablehead = "<input type='text' id='findBy' placeholder='请输入查询内容'/>" +
        "<table width='100%'>\n" +
        "    <thead>\n" +
        "    <tr>\n" +
        "        <th>学号</th>\n" +
        "        <th>姓名</th>\n" +
        "        <th>性别</th>\n" +
        "        <th>专业</th>\n" +
        "        <th>班级</th>\n" +
        "        <th>电话</th>\n" +
        "        <th>状态</th>\n" +
        "        <th>宿舍</th>\n" +
        "        <th>操作</th>\n" +
        "    </tr>\n" +
        "    </thead>\n" +
        "    <tbody id=\"stulist\">\n" +
        "    </tbody>\n" +
        "</table>";
    $("#showData").append(tablehead);
    $.ajax({
        url : "stu/findAll",
        type : "get",
        dataType : "json",
        success : function(result) {
            console.log(result);
            $.each(result, function (n, value) {
                // alert(n + ' ' + value);
                var state = "";
                if (value.state == '0'){
                    state = "<td style='color: #8734ff'>已分配</td>";
                } else {
                    state = "<td style='color: #ff3333'>未分配</td>";
                }
                var roomid = value.roomid;
                if (!value.roomid){
                    roomid = "NULL";
                }
                var trs = "<tr><td>" + value.id + "</td>" +
                    "<td>" + value.name + "</td>" +
                    "<td>" + value.sex + "</td>" +
                    "<td>" + value.major + "</td>" +
                    "<td>" + value.classes + "</td>" +
                    "<td>" + value.phone + "</td>" + state +
                    "<td>" + roomid + "</td>" +
                    "<td><button onclick='up("+value.id+")'>更新</button><button onclick='del("+value.id+")'>删除</button></td></tr>";
                $("#stulist").append(trs);
                //设置文本居中
                $("th,td").css("text-align","center");
            });
        }
    });
    //通过输入框输入内容过滤表格
    $('#findBy').on('input propertychange', function() {
        console.log( $(this).val());
        $('table tbody tr').hide()
            .filter(":contains('" + ($(this).val()) + "')")
            .show();
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
                showStudentTable();
            }
        });
    }
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
    //清空盒子
    $("#showData").empty();
    // $("#showRoomTable").css("display","block");
    var tablehead = "<input type='text' id='findRoom' placeholder='请输入查询内容'/>" +
        "<table width='100%'>\n" +
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
    $("#showData").append(tablehead);
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
                    "<td><button onclick='moreInfo(\""+value.roomid+"\")'>详情</button><button onclick='upRoom(\""+value.roomid+"\")'>更新</button><button onclick='delRoom(\""+value.roomid+"\")'>删除</button></td></tr>";
                $("#roomlist").append(trs);
                //设置文本居中
                $("th,td").css("text-align","center");
            });
        }
    });
    //通过输入框输入内容过滤表格
    $('#findRoom').on('input propertychange', function() {
        console.log( $(this).val());
        $('table tbody tr').hide()
            .filter(":contains('" + ($(this).val()) + "')")
            .show();
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
                if (value == ""){
                    $("#ok").click(function () {
                        var dia = document.getElementById('dia');
                        dia.style.display = 'none';
                    });
                } else {
                    var students = value.studentInfos;
                    moreInfo2(students);
                    console.log(students);
                }
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
        var trs = "<tr><td>" + value.id + "</td>" +
            "<td>" + value.major + "</td>" +
            "<td>"+value.name+"</td>" +
            "<td><button onclick='removeStuToRoom("+value.id+")'>移除</button></td></tr>";
        $("#roomInfoBody").append(trs);
    });
    $("#ok").click(function () {
        var dia = document.getElementById('dia');
        dia.style.display = 'none';
    });
}

/**
 * 修改宿舍可入住人数
 */
function upRoom() {
    alert("完善中！");
}
/**
 * 学生从宿舍移除
 */
function removeStuToRoom(id) {
    upStuState("1",id);
    if(confirm("确定移除该学生吗？")){
        $.ajax({
            url : "room_stu/removeStu",
            type : "post",
            data : {id : id},
            success : function() {
                var dia = document.getElementById('dia');
                dia.style.display = 'none';
                showRoomTable();
            }
        });
    }
}
/**
 * 修改学生状态
 */
function upStuState(state,id) {
    //修改学生状态
    $.ajax({
        url : "stu/upstate",
        type : "post",
        data : {state : state,id : id},
        success : function() {}
    });
}

/**
 * 删除宿舍
 */
function delRoom(roomid) {
    getDelRoomStuInfo(roomid);
    if(confirm("宿舍删除后，宿舍内人员信息将会丢失，确定继续吗？")){
        $.ajax({
            url : "room/del",
            type : "post",
            data : {roomid : roomid},
            success : function() {
                showRoomTable();
            }
        });
    }
}
function getDelRoomStuInfo(data) {
    //更改删除宿舍中的学生状态
    $.ajax({
        url : "room_stu/findIdList",
        type : "post",
        data : {roomId : data},
        dataType : "json",
        success : function(result) {
            $.each(result, function (n, value) {
                console.log(value.id);
                upStuState("1",value.id);
            });
        },
        error : function () {
            alert("error");
        }
    });
}


/**
 * 未分配宿舍学生名单
 */
function UnallocatedStudentTable() {
    $("#unallocatedSyu").addClass("clkFontColor").parent().siblings().children().removeClass("clkFontColor");
    //清空盒子
    $("#showData").empty();
    // $("#showUnallocatedStuTable").css("display","block");
    var tablehead = "<input type='text' id='findUnStu' placeholder='请输入查询内容'/>" +
        "<table width='100%'>\n" +
        "    <thead>\n" +
        "    <tr>\n" +
        "        <th>学号</th>\n" +
        "        <th>姓名</th>\n" +
        "        <th>性别</th>\n" +
        "        <th>专业</th>\n" +
        "        <th>班级</th>\n" +
        "        <th>电话</th>\n" +
        "        <th>状态</th>\n" +
        "        <th>操作</th>\n" +
        "    </tr>\n" +
        "    </thead>\n" +
        "    <tbody id=\"unStulist\">\n" +
        "    </tbody>\n" +
        "</table>";
    $("#showData").append(tablehead);
    //请求数据
    $.ajax({
        url : "stu/findByState",
        type : "post",
        data : {
            state : "1"
        },
        dataType : "json",
        success : function(result) {
            console.log(result);
            $.each(result, function (n, value) {
                var trs = "<tr><td>" + value.id + "</td>" +
                    "<td>" + value.name + "</td>" +
                    "<td>" + value.sex + "</td>" +
                    "<td>" + value.major + "</td>" +
                    "<td>" + value.classes + "</td>" +
                    "<td>" + value.phone + "</td>" +
                    "<td style='color: #ff3333'>未分配</td>" +
                    "<td><button onclick='checkIn("+value.id+")'>分配</button></td></tr>";
                $("#unStulist").append(trs);
                //设置文本居中
                $("th,td").css("text-align","center");
            });
        }
    });
    //通过输入框输入内容过滤表格
    $('#findUnStu').on('input propertychange', function() {
        console.log( $(this).val());
        $('table tbody tr').hide()
            .filter(":contains('" + ($(this).val()) + "')")
            .show();
    });
}

/**
 * 宿舍分配
 */
function checkIn(id) {
    alert("完善中");
    //弹出div
    var dia = document.getElementById('diaStu');
    dia.style.display = (dia.style.display == 'none') ? 'block' : 'none';
    //清楚无用子节点
    $("#updateRoom").empty().append("<option>请选择宿舍号</option>");
    //查询拥有空床位的宿舍号
    $.ajax({
        url : "room/checkIn",
        type : "get",
        dataType : "json",
        success : function(result) {
            $.each(result, function (n, value) {
                var trs = "<option value='" + value.roomid + "'>" + value.roomid + "</option>";
                $("#updateRoom").append(trs);
            });
        },
        error : function () {
            alert("error");
        }
    });
}

/**
 * 访客列表
 */
function showVisitorTable() {
    $("#visitorInfo").addClass("clkFontColor").parent().siblings().children().removeClass("clkFontColor");
    //清空盒子
    $("#showData").empty();
    var tablehead = "<input type='text' id='findVisit' placeholder='请输入查询内容'/>" +
        "<table width='100%'>\n" +
        "    <thead>\n" +
        "    <tr>\n" +
        "        <th>姓名</th>\n" +
        "        <th>电话</th>\n" +
        "        <th>时间</th>\n" +
        "        <th>备注</th>\n" +
        "    </tr>\n" +
        "    </thead>\n" +
        "    <tbody id=\"visitList\">\n" +
        "    </tbody>\n" +
        "</table>";
    $("#showData").append(tablehead);
    //请求数据
    $.ajax({
        url : "vis/findAll",
        type : "get",
        dataType : "json",
        success : function(result) {
            console.log(result);
            $.each(result, function (n, value) {
                var trs = "<tr><td>" + value.visitName + "</td>" +
                    "<td>" + value.visitPhone + "</td>" +
                    "<td>" + timestampToTime(value.visitTime) + "</td>" +
                    "<td>" + value.visitRemarks +"</td></tr>";
                $("#visitList").append(trs);
                //设置文本居中
                $("th,td").css("text-align","center");
            });
        }
    });
    //通过输入框输入内容过滤表格
    $('#findVisit').on('input propertychange', function() {
        console.log( $(this).val());
        $('table tbody tr').hide()
            .filter(":contains('" + ($(this).val()) + "')")
            .show();
    });
}

/**
 * 访客添加
 */
function addVisit() {
    $("#showData").empty();
    var table = "<table>\n" +
        "    <tr>\n" +
        "        <td>姓名：</td>\n" +
        "        <td><input id='visitName'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>电话：</td>\n" +
        "        <td><input id='visitPhone'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>备注：</td>\n" +
        "        <td><input id='visitRemarks'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td></td>\n" +
        "        <td><input id='submit' type='submit' value='提交'/></td>\n" +
        "    </tr>\n" +
        "</table>";
    $("#showData").append(table);
    $("tr,td").css("text-align","center");
    $("#submit").click(function () {
        $.ajax({
            url : "vis/add",
            type : "post",
            data : {
                visitName : $("#visitName").val(),
                visitPhone : $("#visitPhone").val(),
                visitRemarks : $("#visitRemarks").val()
            },
            success : function() {
                alert("登记成功！");
                showVisitorTable();
            },
            error : function () {
                alert("error");
            }
        });
    });
}









/**
 * 时间戳转日期
*/
function timestampToTime(timestamp) {
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    Y = date.getFullYear() + '-';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    D = date.getDate() + ' ';
    h = date.getHours() + ':';
    m = (date.getMinutes() < 10 ? '0'+(date.getMinutes()) : date.getMinutes()) + ':';
    s = (date.getSeconds() < 10 ? '0'+(date.getSeconds()) : date.getSeconds());
    return Y+M+D+h+m+s;
}
/**
 * 显示logo
 */
function showLogo() {
    $("#logo").addClass("clkFontColor").parent().siblings().children().removeClass("clkFontColor");
    $("#showData").empty().append("<img src=\"images/8.png\" width=\"100%\"/>");
}




function caiDan() {
    var trigger = null;
    var audio= new Audio("musics/bgm.mp3");
    $("#caiDan").hover(function(){
        trigger = setTimeout(function(){
            audio.play();
        },6000);
    },function(){
        clearTimeout(trigger);
        audio.pause();
        audio.currentTime = 0;
    });
}




