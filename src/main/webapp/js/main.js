/**
 * 显示学生数据
 */
function showStudentTable() {
    $('#findBy').val("");
    $("#stuInfo").addClass("clkFontColor").parent().siblings().children().removeClass("clkFontColor");
    //清空盒子
    $("#showData").empty();
    var tablehead = "<table width='100%'>\n" +
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
                    "<td><button onclick='up(\""+value.id+"\",\""+roomid+"\")'>换宿</button><button onclick='del("+value.id+")'>删除</button></td></tr>";
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
 * 学生换宿
 */
function up(id,roomid) {
    if (roomid=="NULL"){
        alert("请先为该学生分配宿舍！！");
        return
    }
    showTanChuang();
    var dia = document.getElementById('diaStu');
    //清楚无用子节点
    $("#update").empty().append("<option>请选择宿舍号</option></br>");
    //查询拥有空床位的宿舍号
    $.ajax({
        url : "room/checkIn",
        type : "get",
        dataType : "json",
        success : function(result) {
            $.each(result, function (n, value) {
                var trs = "<option value='" + value.roomid + "'>" + value.roomid + "</option>";
                $("#update").append(trs);
            });
        },
        error : function () {
            alert("error");
        }
    });
    $("#diaStu").append("<button id='checkInOk'>确定</button><button id='checkInNo'>取消</button>");
    $("#checkInNo").click(function () {
        dia.style.display = 'none';
    });
    //获取选择的值
    $("#update").change(function(){
        $("#checkInOk").click(function () {
            dia.style.display = (dia.style.display == 'none') ? 'block' : 'none';
            $.ajax({
                url : "room_stu/upStuRoomid",
                type : "post",
                data : {
                    roomid : $("#update").val(),
                    id : id
                },
                success : function() {
                    alert("修改成功！");
                    showStudentTable();
                },
                error : function () {
                    alert("error");
                }
            });
        });
    });
}
/**
 * 显示宿舍数据
 */
function showRoomTable() {
    $('#findBy').val("");
    $("#roomInfo").addClass("clkFontColor").parent().siblings().children().removeClass("clkFontColor");
    //清空盒子
    $("#showData").empty();
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
                if (value.remarks == "" || value.remarks == null){
                    value.remarks = "无";
                }
                var trs = "<tr><td>" + value.roomid + "</td>" +
                    "<td>" + value.in + "</td>" +
                    "<td>" + value.ining + "</td>" +
                    "<td>" + value.surplus + "</td>" +
                    "<td>" + value.password + "</td>" +
                    "<td>" + value.remarks + "</td>" +
                    "<td><button onclick='moreInfo(\""+value.roomid+"\")'>详情</button><button onclick='upRoom(\""+value.roomid+"\",\""+value.ining+"\")'>更新</button><button onclick='delRoom(\""+value.roomid+"\")'>删除</button></td></tr>";
                $("#roomlist").append(trs);
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
        data : {roomid : roomid},
        dataType : "json",
        success : function(result) {
            //设置清单头部信息  宿舍编号和宿舍已入住人数
            $("#roomId").text("宿舍:"+roomid).css("color","#ffffff");
            $("#roomIn").text("已入住"+result.length+"人").css("color","#ffffff");
            $.each(result, function (n, value) {
                if (value == ""){
                    $("#ok").click(function () {
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
function upRoom(roomid,ining) {
    showTanChuang();
    var dia = document.getElementById('diaStu');
    //清楚无用子节点
    $("#update").empty().append("<option>请选择可入住人数</option>");
    for (ining;ining <= 7;ining++) {
        var str = "<option value='" + ining + "'>" + ining + "</option>";
        $("#update").append(str);
    }

    $("#diaStu").append("<button id='okBtu'>确定</button><button id='unBtu'>取消</button>");
    //获取选择的值
    $("#update").change(function(){
        $("#okBtu").click(function () {
            dia.style.display = (dia.style.display == 'none') ? 'block' : 'none';
            updateRoomIn(roomid,$("#update").val());
        });
    });
    $("#unBtu").click(function () {
        dia.style.display = 'none';
    });
}
function updateRoomIn(roomid,roomIn) {
    $.ajax({
        url : "room/updateRoomIn",
        type : "post",
        data : {
            roomid : roomid,
            roomin : roomIn
        },
        success : function() {
            alert("修改成功！");
            showRoomTable();
        },
        error : function () {
            alert("error");
        }
    });
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
    $('#findBy').val("");
    $("#unallocatedSyu").addClass("clkFontColor").parent().siblings().children().removeClass("clkFontColor");
    //清空盒子
    $("#showData").empty();
    var tablehead = "<table width='100%'>\n" +
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
    $('#findBy').on('input propertychange', function() {
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
    showTanChuang();
    var dia = document.getElementById('diaStu');
    //清楚无用子节点
    $("#update").empty().append("<option>请选择宿舍号</option>");
    //查询拥有空床位的宿舍号
    $.ajax({
        url : "room/checkIn",
        type : "get",
        dataType : "json",
        success : function(result) {
            $.each(result, function (n, value) {
                var trs = "<option value='" + value.roomid + "'>" + value.roomid + "</option>";
                $("#update").append(trs);
            });
        },
        error : function () {
            alert("error");
        }
    });
    $("#diaStu").append("<button id='checkInOk'>提交</button><button id='checkInNo'>取消</button>");
    $("#checkInNo").click(function () {
        dia.style.display = 'none';
    });
    //获取选择的值
    $("#update").change(function(){
        $("#checkInOk").click(function () {
            dia.style.display = (dia.style.display == 'none') ? 'block' : 'none';
            checkInOk($("#update").val(),id);
        });
    });
}
function checkInOk(roomId,id) {
    $.ajax({
        url : "room_stu/addStuToRoom",
        type : "post",
        data : {
            roomid : roomId,
            id : id
        },
        success : function() {
            upStuState("0",id);
            alert("分配成功！");
            UnallocatedStudentTable();
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
    $('#findBy').val("");
    $("#visitorInfo").addClass("clkFontColor").parent().siblings().children().removeClass("clkFontColor");
    //清空盒子
    $("#showData").empty();
    var tablehead = "<table width='100%'>\n" +
        "    <thead>\n" +
        "    <tr>\n" +
        "        <th>来访者姓名</th>\n" +
        "        <th>来访者电话</th>\n" +
        "        <th>来访时间</th>\n" +
        "        <th>被访者姓名</th>\n" +
        "        <th>被访者宿舍</th>\n" +
        "        <th>来访原由</th>\n" +
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
                    "<td>" + value.stuName + "</td>" +
                    "<td>" + value.stuRoom + "</td>" +
                    "<td>" + value.visitRemarks +"</td></tr>";
                $("#visitList").append(trs);
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
 * 访客添加
 */
function addVisit() {
    $("#showData").empty();
    var table = "<table>\n" +
        "    <tr>\n" +
        "        <td>来访者姓名：</td>\n" +
        "        <td><input id='visitName'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>来访者电话：</td>\n" +
        "        <td><input id='visitPhone'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>被访者姓名：</td>\n" +
        "        <td><input id='stuName'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>被访者宿舍：</td>\n" +
        "        <td><input id='stuRoom'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>来访原由：</td>\n" +
        "        <td><input id='visitRemarks'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td><input type='submit' onclick='showLogo()' value='取消'/></td>\n" +
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
                stuName : $("#stuName").val(),
                stuRoom : $("#stuRoom").val(),
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
 * 添加学生
 */
function addStu() {
    $("#showData").empty();
    var table = "<table>\n" +
        "    <tr>\n" +
        "        <td>学号：</td>\n" +
        "        <td><input id='stuId'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>姓名：</td>\n" +
        "        <td><input id='stuName'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>性别：</td>\n" +
        "        <td><input id='stuSex'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>专业：</td>\n" +
        "        <td><input id='stuMajor'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>班级：</td>\n" +
        "        <td><input id='stuClasses'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>电话：</td>\n" +
        "        <td><input id='stuPhone'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td><input type='submit' onclick='showLogo()' value='取消'/></td>\n" +
        "        <td><input id='submit' type='submit' value='提交'/></td>\n" +
        "    </tr>\n" +
        "</table>";
    $("#showData").append(table);
    $("tr,td").css("text-align","center");
    $("#submit").click(function () {
        var meg = "";
        $("input").each(function () {
            if ($(this).val()==""){
                meg = "1";
                $(this).parent().css("border","1px solid red");
            }
        });
        if (meg=="1"){
            alert("输入信息不全！");
            return;
        }
        $.ajax({
            url : "stu/add",
            type : "post",
            data : {
                id : $("#stuId").val(),
                name : $("#stuName").val(),
                sex : $("#stuSex").val(),
                major : $("#stuMajor").val(),
                classes : $("#stuClasses").val(),
                phone : $("#stuPhone").val(),
                state : "1"
            },
            success : function() {
                if(confirm("学生信息录入成功！\n是否继续录入？")){
                    addStu();
                }else {
                    UnallocatedStudentTable();
                }
            },
            error : function () {
                alert("error");
            }
        });
    });
}


/**
 * 添加寝室
 */
function addRoom() {
    $("#showData").empty();
    var table = "<table>\n" +
        "    <tr>\n" +
        "        <td>寝室编号：</td>\n" +
        "        <td><input id='roomId'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>可入住人数：</td>\n" +
        "        <td><input id='roomIn'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>寝室密码：</td>\n" +
        "        <td><input id='roomPass'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>备注：</td>\n" +
        "        <td><input id='roomRem'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td><input type='submit' onclick='showLogo()' value='取消'/></td>\n" +
        "        <td><input id='submit' type='submit' value='提交'/></td>\n" +
        "    </tr>\n" +
        "</table>";
    $("#showData").append(table);
    $("tr,td").css("text-align","center");
    $("#submit").click(function () {
        if ($("#roomIn").val() > 8 || $("#roomIn").val() == ""){
            alert("可入住人数设置错误");
            $("#roomIn").val("");
            return;
        }
        $.ajax({
            url : "room/add",
            type : "post",
            data : {
                roomid : $("#roomId").val(),
                roomin : $("#roomIn").val(),
                password : $("#roomPass").val(),
                remarks : $("#roomRem").val()
            },
            success : function() {
                if(confirm("寝室添加成功！\n是否继续添加？")){
                    addRoom();
                }else {
                    showRoomTable();
                }
            },
            error : function () {
                alert("error");
            }
        });
    });
}
/**
 * root用户添加管理员
 */
function addMan(data) {
    if (data != "root"){
        alert("权限不足！请联系银河领主小浩！");
    }else {
        $("#showData").empty();
        var table = "<table>\n" +
            "    <tr>\n" +
            "        <td>用户名：</td>\n" +
            "        <td><input id='userName'/></td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td>密码：</td>\n" +
            "        <td><input id='pass' type='password'/></td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td><input type='submit' onclick='showLogo()' value='取消'/></td>\n" +
            "        <td><input id='submit' type='submit' value='提交'/></td>\n" +
            "    </tr>\n" +
            "</table>";
        $("#showData").append(table);
        $("tr,td").css("text-align","center");
        $("#submit").click(function () {
            $.ajax({
                url : "sign/add",
                type : "post",
                data : {
                    username : $("#userName").val(),
                    password : $("#pass").val()
                },
                success : function() {
                    if(confirm("管理员添加成功！\n是否继续录入？")){
                        addMan("root");
                    }else {
                        showManagerInfo(data);
                    }
                },
                error : function () {
                    alert("error");
                }
            });
        });
    }
}

/**
 * admin页面报修信息
 */
function repairTable() {
    $('#findBy').val("");
    $("#repairInfo").addClass("clkFontColor").parent().siblings().children().removeClass("clkFontColor");
    //清空盒子
    $("#showData").empty();
    var tablehead = "<table width='100%'>\n" +
        "    <thead>\n" +
        "    <tr>\n" +
        "        <th>寝室</th>\n" +
        "        <th>报修时间</th>\n" +
        "        <th>内容</th>\n" +
        "        <th>完成时间</th>\n" +
        "        <th>状态</th>\n" +
        "    </tr>\n" +
        "    </thead>\n" +
        "    <tbody id=\"repairTable\">\n" +
        "    </tbody>\n" +
        "</table>";
    $("#showData").append(tablehead);
    //请求数据
    $.ajax({
        url : "repair/findAll",
        type : "get",
        dataType : "json",
        success : function(result) {
            console.log(result);
            $.each(result, function (n, value) {
                var state = "<td style='color: #8734ff'>已完成</td>";
                var endTime = value.endTime;
                if (value.repairState == "1"){
                    state = "<td style='color: red'>报修中</td>";
                    endTime = "未完成";
                }else {
                    endTime = timestampToTime(value.endTime);
                }
                var trs = "<tr><td>" + value.repairName + "</td>" +
                    "<td>" + timestampToTime(value.repairTime) + "</td>" +
                    "<td>" + value.repairText + "</td>" +
                    "<td>" + endTime + "</td>" + state
                "</tr>";
                $("#repairTable").append(trs);
                //设置文本居中
                $("th,td").css("text-align","center");
            });
        }
    });
}

/**
 * 管理员列表
 */
function showManagerInfo(data) {
    $('#findBy').val("");
    if (data != "root"){
        alert("权限不足！请联系银河领主小浩！");
    }else {
        $("#managerInfo").addClass("clkFontColor").parent().siblings().children().removeClass("clkFontColor");
        //清空盒子
        $("#showData").empty();
        var tablehead = "<table width='100%'>\n" +
            "    <thead>\n" +
            "    <tr>\n" +
            "        <th>姓名</th>\n" +
            "        <th>密码</th>\n" +
            "        <th>操作</th>\n" +
            "    </tr>\n" +
            "    </thead>\n" +
            "    <tbody id=\"managerList\">\n" +
            "    </tbody>\n" +
            "</table>";
        $("#showData").append(tablehead);
        //请求数据
        $.ajax({
            url : "sign/findAll",
            type : "get",
            dataType : "json",
            success : function(result) {
                $.each(result, function (n, value) {
                    if (value.username != 'root'){
                        var trs = "<tr><td>" + value.username + "</td>" +
                            "<td>" + value.password +"</td>" +
                            "<td><button onclick='delMan("+value.username+")'>删除</button><td></tr>";
                        $("#managerList").append(trs);
                    }
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
}

/**
 * 管理员删除
 * @param data
 */
function delMan(data) {
    if(confirm("确定删除该管理员吗？")){
        $.ajax({
            url : "sign/del",
            type : "post",
            data : {username  : data},
            success : function() {
                alert("删除成功！");
                showManagerInfo("root");
            }
        });
    }
}















/**
 * 用户页面宿舍详情
 */
function Info(roomid) {
    $("#userRoomInfo").addClass("clkFontColor").parent().siblings().children().removeClass("clkFontColor");
    //清楚无用子节点
    $("#showData").empty();
    var tablehead = "<table width='100%'>\n" +
        "    <thead>\n" +
        "    <tr>\n" +
        "        <th>学号</th>\n" +
        "        <th>姓名</th>\n" +
        "        <th>性别</th>\n" +
        "        <th>专业</th>\n" +
        "        <th>班级</th>\n" +
        "        <th>电话</th>\n" +
        "    </tr>\n" +
        "    </thead>\n" +
        "    <tbody id=\"stuList\">\n" +
        "    </tbody>\n" +
        "</table>";
    $("#showData").append(tablehead);
    //查询宿舍具体信息
    $.ajax({
        url : "room_stu/findAllStu",
        type : "post",
        data : {
            roomid : roomid
        },
        dataType : "json",
        success : function(result) {
            console.log(result);
            $.each(result, function (n, value) {
                $.each(value.studentInfos,function (o,p) {
                    var trs = "<tr><td>" + value.id + "</td>" +
                        "<td>" + p.name + "</td>" +
                        "<td>" + p.sex + "</td>" +
                        "<td>" + p.major + "</td>" +
                        "<td>" + p.classes + "</td>" +
                        "<td>" + p.phone + "</td></tr>";
                    $("#stuList").append(trs);
                    $("th,td").css("text-align","center");
                });
            });
        },
        error : function () {
            alert("error");
        }
    });
}

/**
 * 用户提交报修信息
 */
function subRepair(repairName) {
    $.ajax({
        url : "repair/addRepair",
        type : "post",
        data : {
            repairName : repairName,
            repairText : $("textarea").val(),
            repairState : "1"
        },
        success : function() {
            alert("报修成功！");
            findOldRepair(repairName);
        },
        error : function () {
            alert("error");
        }
    });
}

/**
 * 用户查看报修记录
 */
function findOldRepair(repairName) {
    $("#userRepair").addClass("clkFontColor").parent().siblings().children().removeClass("clkFontColor");
    //清楚无用子节点
    $("#showData").empty();
    var tablehead = "<table width='100%'>\n" +
        "    <thead>\n" +
        "    <tr>\n" +
        "        <th>报修寝室</th>\n" +
        "        <th>报修时间</th>\n" +
        "        <th>报修内容</th>\n" +
        "        <th>完成时间</th>\n" +
        "        <th>报修状态</th>\n" +
        "        <th>报修确认</th>\n" +
        "    </tr>\n" +
        "    </thead>\n" +
        "    <tbody id=\"List\">\n" +
        "    </tbody>\n" +
        "</table>";
    $("#showData").append(tablehead);
    //查询宿舍具体信息
    $.ajax({
        url : "repair/findByRoomId",
        type : "post",
        data : {
            repairName : repairName
        },
        dataType : "json",
        success : function(result) {
            console.log(result);
            $.each(result, function (n, value) {
                var state = "<td style='color: aqua'>已完成</td>";
                var endTime = value.endTime;
                var repairOk = "<td><button style='color: darkgrey'>已确认</button></td>";
                if (value.repairState == "1"){
                    state = "<td style='color: red'>报修中</td>";
                    endTime = "未完成";
                    repairOk = "<td><input type='submit' onclick=\"repairOk("+value.repairId+",'"+value.repairName+"')\" value='确认'/></td>";
                }else {
                    endTime = timestampToTime(value.endTime);
                }
                var trs = "<tr><td>" + value.repairName + "</td>" +
                    "<td>" + timestampToTime(value.repairTime) + "</td>" +
                    "<td>" + value.repairText + "</td>" +
                    "<td>" + endTime + "</td>" + state + repairOk
                "</tr>";
                $("#List").append(trs);
                $("th,td").css("text-align","center");
            });
        },
        error : function () {
            alert("error");
        }
    });
}

/**
 * 用户确认报修完成
 */
function repairOk(id,name) {
    $.ajax({
        url : "repair/upState",
        type : "post",
        data : {
            repairId : id,
            repairState : "0"
        },
        success : function() {
            alert("确认成功！");
            findOldRepair(name);
        },
        error : function () {
            alert("error");
        }
    });
}










/**
 * 退出logout
 */
function logout() {
    $.ajax({
        url : "sign/logout",
        type : "get",
        success : function() {
            $(location).attr("href","login.jsp");
        }
    });
}

/**
 * 管理员修改密码
 */
function upAdminPass(adminName) {
    $("#showData").empty();
    var table = "<table>\n" +
        "    <tr>\n" +
        "        <td>旧密码：</td>\n" +
        "        <td><input type='password' id='oldPass'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>新密码：</td>\n" +
        "        <td><input type='password' id='newPass'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>确认密码：</td>\n" +
        "        <td><input type='password' id='newPass2'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td><a href='index.jsp'>取消</a></td>\n" +
        "        <td><input id='submit' type='submit' value='提交'/></td>\n" +
        "    </tr>\n" +
        "</table>";
    $("#showData").append(table);
    $("tr,td").css("text-align","center");

    $("#oldPass").blur(function () {
            $.ajax({
                url : "sign/log",
                type : "post",
                data : {
                    username : adminName,
                    password : $("#oldPass").val()
                },
                dataType : "json",
                success : function(result) {
                    if (result == "1"){
                        alert("旧密码错误！");
                        $("#oldPass").val("");
                    }
                },
                error : function () {
                    alert("error");
                }
            });
    });
    $("#submit").click(function () {
        if ($("#oldPass").val() == "" || $("#newPass").val() == "" || $("#newPass2").val() == "") {
            alert("输入信息不全！");
        }else {
            if ($("#newPass").val() == $("#newPass2").val()) {
                $.ajax({
                    url : "sign/update",
                    type : "post",
                    data : {
                        username : adminName,
                        password : $("#newPass").val()
                    },
                    success : function() {
                        alert("修改成功！");
                        $(location).attr("href","login.jsp");
                    },
                    error : function () {
                        alert("error");
                    }
                });
            }else {
                alert("两次输入密码不一致！");
                $("#newPass2").val("");
            }
        }
    });
}

/**
 * 用户修改密码
 */
function upUserPass(roomid) {
    $("#showData").empty();
    var table = "<table>\n" +
        "    <tr>\n" +
        "        <td>旧密码：</td>\n" +
        "        <td><input type='password' id='oldPas'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>新密码：</td>\n" +
        "        <td><input type='password' id='newPas'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td>确认密码：</td>\n" +
        "        <td><input type='password' id='newPas2'/></td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td><a href='userIndex.jsp'>取消</a></td>\n" +
        "        <td><input id='submit' type='submit' value='提交'/></td>\n" +
        "    </tr>\n" +
        "</table>";
    $("#showData").append(table);
    $("tr,td").css("text-align","center");

    $("#oldPas").blur(function () {
        $.ajax({
            url : "room/log",
            type : "post",
            data : {
                roomid : roomid,
                password : $("#oldPas").val()
            },
            success : function(result) {
                if (result == "1"){
                    alert("旧密码错误！");
                    $("#oldPas").val("");
                }
            },
            error : function () {
                alert("error");
            }
        });
    });
    $("#submit").click(function () {
        if ($("#oldPas").val() == "" || $("#newPas").val() == "" || $("#newPas2").val() == "") {
            alert("输入信息不全！");
        }else {
            if ($("#newPas").val() == $("#newPas2").val()) {
                $.ajax({
                    url : "room/upUserPass",
                    type : "post",
                    data : {
                        roomid : roomid,
                        password : $("#newPas").val()
                    },
                    success : function() {
                        alert("修改成功！");
                        $(location).attr("href","login.jsp");
                    },
                    error : function () {
                        alert("error");
                    }
                });
            }else {
                alert("两次输入密码不一致！");
                $("#newPas2").val("");
            }
        }
    });
}


/**
 * 取消弹窗
 */
function showTanChuang() {
    var str = "<div class='login-box'>\n" +
        "            <select id=\"update\" style=\"margin-left: 200px;\"></select>\n" +
        "        </div>"
    $("#diaStu").empty().append(str);
    //弹出div
    var dia = document.getElementById('diaStu');
    dia.style.display = (dia.style.display == 'none') ? 'block' : 'none';
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




