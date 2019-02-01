function ajaxsubmitadddevice() {
    $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"rest/page/adddevice",
            //提交的数据
            data: {
                code: $("#form_code").val(),
                name: $("#form_name").val(),
                company: $("#form_company").val(),
                deliverytime: $("#form_deliverytime").val(),
                endtime: $("#form_endtime").val()
            },
            //返回数据的格式
            datatype: "html",
            //在请求之前调用的函数
            beforeSend:function(){},
            //成功返回之后调用的函数
            success:function(data){
                $("#adddevice").modal("hide");
                $(".modal-backdrop").remove();
                $('#main-content').html(data);
                // alert(data);
            }   ,
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
                // $('#main-content').html(data);
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
            }
        }
    )

    return false;
}

function addlocalengineer() {
    var imgfile = $("#headimg").get(0).files[0];
    // var datafile = new FormData($("#addlocalengineersub")[0]);
    // console.log(imgfile);
    $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"rest/page/addlocalengineer",
            //提交的数据
            data: {
                name: $("[name='name']").val(),
                headimg: imgfile,
                number: $("[name='number']").val(),
                company: $("[name='company']").val(),
                partment: $("[name='partment']").val(),
                level: $("[name='level']").val()
            },
            //返回数据的格式
            datatype: "html",
            //在请求之前调用的函数
            beforeSend:function(){},
            //成功返回之后调用的函数
            success:function(data){
                alert("succ");
                console.log(data);
                // $("#addlocalengineer").modal("hide");
                // $(".modal-backdrop").remove();
                // $('#main-content').html(data);
                // alert(data);
            }   ,
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
                // $('#main-content').html(data);
                alert("comp");
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
                alert("err");
            }
        }
    )

    return false;
}

function ajaxsubmitaddjob() {
    $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"rest/page/addjob",
            //提交的数据
            data: {
                type: $("#form_job_type").val(),
                device: $("#form_job_device").val(),
                devicecode: $("#form_job_devicecode").val(),
                company: $("#form_job_company").val(),
                desc: $("#form_job_desc").val(),
                localengineer: $("#form_job_localengineer").val(),
                remoteengineer: $("#form_job_remoteengineer").val(),
                finishtime: $("#form_job_finishtime").val()
            },
            //返回数据的格式
            datatype: "html",
            //在请求之前调用的函数
            beforeSend:function(){},
            //成功返回之后调用的函数
            success:function(data){
                $("#addjob").modal("hide");
                $(".modal-backdrop").remove();
                $('#main-content').html(data);
                // alert(data);
            }   ,
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
                // $('#main-content').html(data);
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
            }
        }
    )

    return false;
}

function getEngineerHeadImg(obj) {
    $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"rest/page/addjob",
            //提交的数据
            data: {
                desc: $("#form_job_desc").val()
            },
            //返回数据的格式
            datatype: "html",
            //在请求之前调用的函数
            beforeSend:function(){},
            //成功返回之后调用的函数
            success:function(data){
                $("#addjob").modal("hide");
                $(".modal-backdrop").remove();
                $('#main-content').html(data);
                // alert(data);
            }   ,
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
                // $('#main-content').html(data);
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
            }
        }
    )
}
//
// $(function() {
//     $('#form_deliverytime').datepicker({
//         language: 'pt-BR'
//     });
// });

function ajaxregister() {
    $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"rest/user/registeruser",
            //提交的数据
            data: {
                // fullname: $("[name='fullname']").val(),
                // email: $("[name='email']").val(),
                // address: $("[name='address']").val(),
                // city: $("[name='city']").val(),
                // country: $("[name='country']").val(),
                username: $("[name='username']").val(),
                password: $("[name='password']").val()
            },
            //返回数据的格式
            datatype: "html",
            //在请求之前调用的函数
            beforeSend:function(){},
            //成功返回之后调用的函数
            success:function(data){
                alert("done");
                alert("success");
            }   ,
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
                // $('#main-content').html(data);
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
                alert("error");
            }
        }
    )

    return false;
}

function showrecord(obj) {
    var id = $(obj).parents('tr').children().eq(1).text();
    $.ajax({
        //提交数据的类型 POST GET
        type:"POST",
        //提交的网址
        url:"rest/page/getoprecord",
        //提交的数据
        data: {
            deviceid: id
        },
        //返回数据的格式
        datatype: "json",
        //在请求之前调用的函数
        beforeSend:function(){},
        //成功返回之后调用的函数
        success:function(data){
            var content = "<table class=\"table table-striped table-bordered table-hover table-checkable order-column\"> \
                <thead> \
                    <tr> \
                        <th>编号</th> \
                        <th>设备编号</th> \
                        <th>操作员</th> \
                        <th>操作时间</th> \
                        <th>内容</th> \
                        <th>类型</th> \
                    </tr> \
                </thead> \
                <tbody> \
                ";
                for (var i = 0; i < data.result.length; i++) {
                    content += "<tr class=\"odd gradeX\">"
                    content += "<td>" + data.result[i].id + "</td>";
                    content += "<td>" + data.result[i].deciveid + "</td>";
                    content += "<td>" + data.result[i].opengineer + "</td>";
                    content += "<td>" + data.result[i].opdate + "</td>";
                    content += "<td>" + data.result[i].opcontent + "</td>";
                    if (data.result[i].type == 0)
                        content += "<td>" + "运维操作" + "</td>";
                    else if (data.result[i].type == 1)
                        content += "<td>" + "更换耗材" + "</td>";
                    content += "</tr>"
                }
                content += " </tbody></table>";
                $('#dialogSelect').html(content);

            $('#dialogSelect').dialog({
                autoOpen: false,modal:true,width:600,height:400,title:"设备操作记录",
                buttons: {
                    "关闭": function() { $(this).dialog("close"); }
                }
            });

            $('#dialogSelect').dialog("open");
        }   ,
        //调用执行后调用的函数
        complete: function(XMLHttpRequest, textStatus){
            // alert(XMLHttpRequest);
            // $('#main-content').html(data);
        },
        //调用出错执行的函数
        error: function(){
            //请求出错处理
        }
    })
}

function deletedevice(obj) {
    var res = confirm('确认要删除吗？');
    if(res == true)
    {
        var id = $(obj).parents('tr').children().eq(1).text();
        $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"rest/page/deletedevice",
            //提交的数据
            data: {
                deviceid: id
            },
            //返回数据的格式
            datatype: "html",
            //在请求之前调用的函数
            beforeSend:function(){},
            //成功返回之后调用的函数
            success:function(data){
            }   ,
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
                // $('#main-content').html(data);
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
            }
        })
        $(obj).parents("tr").remove();

    }
}

function modifydevice(obj) {
    var modifyState = false;
    if ($(obj).text() == "修改") {
        modifyState = true;
        $(obj).text("确定");
    }
    else {
        $(obj).text("修改");
    }
    var parent = $(obj).parents('tr').children();
    var nameView = parent.eq(2);
    var starttimeView = parent.eq(4);
    var statusView = parent.eq(5);
    var endtimeView = parent.eq(6);
    var id = $(obj).parents('tr').children().eq(1).text();

    if (modifyState) {
        var content = nameView.text();
        nameView.html("<input id=\"device_name\" type=\"text\" value='" + content + "' maxlength=\"25\" >");
        var starttime = starttimeView.text();
        starttimeView.html("<input id='device_starttime' type=\"text\" readonly=\"\"  value='" + starttime + "'>" +
            "<script>$(function() { $( \"#device_starttime\" ).datepicker({dateFormat: \"yy-mm-dd\"});  });</script>" +
            "</input>");
        var endtime = endtimeView.text();
        endtimeView.html("<input id='device_endtime' type=\"text\" readonly=\"\" value='" + endtime + "'>" +
            "<script>$(function() { $( \"#device_endtime\" ).datepicker({dateFormat: \"yy-mm-dd\"});  });</script>" +
            "</input>");
        statusView.html("<select id=\"device_status\">" +
            "<option value='0'>正常</option>" +
            "<option value='1'>异常</option></select>");
    }
    else {
        var text = nameView.find("input:text").val();//$("#device_name").val();
        nameView.html(text);

        var starttime = $("#device_starttime").val();
        starttimeView.html(starttime);
        var endtime = $("#device_endtime").val();
        endtimeView.html(endtime);
        var statusText = $("#device_status option:selected").text();
        var statusVal = $("#device_status option:selected").val();
        statusView.html(statusText);
        ajaxsubmitupdatedevice(id, text, starttime, endtime, statusVal);
    }

}

function ajaxsubmitupdatedevice(id, name, starttime, endtime, status) {
    $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"rest/page/updatedevice",
            //提交的数据
            data: {
                deviceid: id,
                name: name,
                company: "",
                deliverytime: starttime,
                endtime: endtime,
                status: status
            },
            //返回数据的格式
            datatype: "html",
            //在请求之前调用的函数
            beforeSend:function(){},
            //成功返回之后调用的函数
            success:function(data){
            }   ,
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
                // $('#main-content').html(data);
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
            }
        }
    )

    return true;
}

var xhrequest;

function check_username(obj) {
    var username = $(obj).val();
    $("#username_check").text("检测中...");
    var path = '/rest/user/checkusername?username=' + username;
    xhrequest = new XMLHttpRequest();
    xhrequest.open('POST', path, true);
    xhrequest.onreadystatechange = checkusernamecallback;
    xhrequest.send();
}

function checkusernamecallback() {
    if (xhrequest.readyState===4 && xhrequest.status===200) {
        console.log(xhrequest.responseText);
        var result = xhrequest.responseText;
        if (result == 1)
            $("#username_check").text("用户名可以使用");
        else
            $("#username_check").text("用户名已被占用");
    }
}


function check_username2(obj) {
    if ($(obj).val().length == 0)
        return true;
    var label = $("#username_check");
    label.text("检测中...");
    label[0].setAttribute("uservalid", "false");
    $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"rest/user/checkusername2",
            //提交的数据
            data: {
                username: $(obj).val()
            },
            //返回数据的格式
            datatype: "html",
            //在请求之前调用的函数
            beforeSend:function(){},
            //成功返回之后调用的函数
            success:function(data){
                if (data == 1) {
                    $("#username_check").text("用户名可以使用");
                    $("#username_check")[0].setAttribute("uservalid", "true");
                }
                else {
                    $("#username_check").text("用户名已被占用");
                    $("#username_check")[0].setAttribute("uservalid", "false");
                }
            }   ,
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
                // $('#main-content').html(data);
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
            }
        }
    )

    return true;
}

function encryptPassword() {
    var password = $("[name='password']").val();
    var rpassword = $("[name='rpassword']").val();
    if (password.length > 0 && password == rpassword) {
        $("[name='password']").val(sha256_digest(password))
        $("[name='rpassword']").val(sha256_digest(rpassword))
    }
}

function checkusernamevalid() {
    var valid = $("#username_check")[0].getAttribute("uservalid");
    if (valid == "false") {
        return false;
    }

    return true;
}

function clickanother(ref) {
    var another = document.getElementById(ref);
    another.click();
}

function operateJob(obj, jobstate) {
    var res;
    if (jobstate == 0)
        res = confirm('是否要开始工作？');
    else if (jobstate == 1)
        res = confirm('是否要结束工作？');
    if(res == true)
    {
        var id = $(obj).parents('tr').children().eq(1).text();
        var jobstatenameView = $(obj).parents('tr').children().eq(10);
        if (jobstate == 0) {
            updatejobState(id, 1);
            jobstatenameView.val('进行中');
        }
        else if (jobstate == 1) {
            updatejobState(id, 2);
            jobstatenameView.val('已完成');
        }
    }
}

function updatejobState(id, jobstate) {
    $.ajax({
        //提交数据的类型 POST GET
        type:"POST",
        //提交的网址
        url:"rest/page/updatejobState",
        //提交的数据
        data: {
            jobid: id,
            jobstate: jobstate
        },
        //返回数据的格式
        datatype: "html",
        //在请求之前调用的函数
        beforeSend:function(){},
        //成功返回之后调用的函数
        success:function(data){
        }   ,
        //调用执行后调用的函数
        complete: function(XMLHttpRequest, textStatus){
            // $('#main-content').html(data);
        },
        //调用出错执行的函数
        error: function(){
            //请求出错处理
        }
    })
}

function endjob(id) {
    $.ajax({
        //提交数据的类型 POST GET
        type:"POST",
        //提交的网址
        url:"rest/page/updatejobState",
        //提交的数据
        data: {
            jobid: id
        },
        //返回数据的格式
        datatype: "html",
        //在请求之前调用的函数
        beforeSend:function(){},
        //成功返回之后调用的函数
        success:function(data){
        }   ,
        //调用执行后调用的函数
        complete: function(XMLHttpRequest, textStatus){
            // $('#main-content').html(data);
        },
        //调用出错执行的函数
        error: function(){
            //请求出错处理
        }
    })
}
